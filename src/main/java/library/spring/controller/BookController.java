package library.spring.controller;

import java.util.List;
import java.util.Optional;
import library.spring.entity.Author;
import library.spring.entity.Book;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/{bookId}")
    public String bookInfo(@PathVariable("bookId") Long bookId, ModelMap model) {
        try {
            Optional<Book> book = bookService.getBook(bookId);
            model.addAttribute("book", book.get());
            model.addAttribute("active", rentService.isBookAvailable(book.get()) ? "YES" : "NO");
            return "info";
        } catch (Exception e) {
            model.addAttribute("errorMsg", "Book not found!");
            LOGGER.error("Book not found. " + e);
            return "forward:/book/all";
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
        List<Book> foundBooks = bookService.findByAuthorSurname(searchString);
        model.addAttribute("foundBooks", foundBooks);
        return "found-books";
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "add-book";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, Model model,
            @RequestParam("name") String name, @RequestParam("surname") String surname) {
        if (book.getTitle().isEmpty() || book.getYear() == null || book.getPrice() == null
                || name.isEmpty() || surname.isEmpty()) {
            model.addAttribute("errorMsg", "Not all required fields are filled.");
            return "redirect:/book/add";
        }
        Author author = new Author(name, surname);
        authorService.addAuthor(author);
        book.addAuthor(author);
        bookService.addBook(book);
        return "redirect:/book/all";
    }
}
