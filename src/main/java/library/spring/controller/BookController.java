package library.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import library.spring.entity.Author;
import library.spring.entity.Book;
import library.spring.exceptions.RequiredFieldsNotFilled;
import library.spring.service.AuthorService;
import library.spring.service.BookService;
import library.spring.service.RentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/book")
public class BookController {
    private static final Logger LOGGER = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private RentService rentService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.getAllBooks());
        return "all";
    }

    @GetMapping("/info")
    public String bookInfo(@RequestParam("bookId") Long bookId, Model model) {
        try {
            Optional<Book> book = bookService.getBook(bookId);
            model.addAttribute("book", book.get());
            model.addAttribute("active", rentService.isBookAvailable(book.get()) ? "YES" : "NO");
            return "info";
        } catch (Exception e) {
            LOGGER.error("Book not found. " + e);
            return "error-book-not-found";
        }
    }

    @GetMapping("/search")
    public String findByTitle() {
        return "search";
    }

    @PostMapping("/found")
    public String findByTitle(@RequestParam(value = "searchString") String searchString,
                              Model model) {
        List<Book> foundBooks = bookService.findByTitle(searchString);
        model.addAttribute("foundBooks", foundBooks);
        return "found-books";
    }

    @GetMapping("/search-author")
    public String findByAuthor() {
        return "search-author";
    }

    @PostMapping("/found-author")
    public String foundByAuthor(@RequestParam(value = "searchString") String searchString,
                                Model model) {
        List<Book> foundBooks = bookService.findByAuthor(searchString);
        model.addAttribute("foundBooks", foundBooks);
        return "found-books";
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "add-book";
    }

    @PostMapping("/add")
    public RedirectView addBook(@ModelAttribute Book book, Model model,
            @RequestParam("name1") String name1, @RequestParam("surname1") String surname1,
            @RequestParam("name2") String name2, @RequestParam("surname2") String surname2) {
        if (book.getTitle().isEmpty() || book.getYear() == null || book.getPrice() == null
                || name1.isEmpty() || surname1.isEmpty()) {
            try {
                throw new RequiredFieldsNotFilled("Not all required fields are filled.");
            } catch (RequiredFieldsNotFilled e) {
                LOGGER.error("Not all required fields are filled.");
                return new RedirectView("add");
            }
        }
        List<Author> authors = new ArrayList<>();
        Author author1 = new Author(name1, surname1);
        authorService.addAuthor(author1);
        authors.add(author1);
        if (!(name2.isEmpty() || surname2.isEmpty())) {
            Author author2 = new Author(name2, surname2);
            authorService.addAuthor(author2);
            authors.add(author2);
        }
        book.setAuthors(authors);
        bookService.addBook(book);
        return new RedirectView("all");
    }
}
