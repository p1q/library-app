package library.spring.controller;

import java.util.Optional;
import library.spring.entity.Book;
import library.spring.service.BookService;
import library.spring.service.RentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BookController {
    private static final Logger LOGGER = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private RentService rentService;

    @GetMapping("/show-all-books")
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.getAllBooks());
        return "show-all-books";
    }

    @GetMapping("/show-book-info")
    public String bookInfo(@RequestParam("bookId") Long bookId, Model model) {
        try {
            Optional<Book> book = bookService.getBook(bookId);
            model.addAttribute("book", book.get());
            model.addAttribute("active", rentService.isBookAvailable(book.get()) ? "YES" : "NO");
            return "show-book-info";
        } catch (Exception e) {
            LOGGER.error("Book not found. " + e);
            return "error-book-not-found";
        }
    }
}
