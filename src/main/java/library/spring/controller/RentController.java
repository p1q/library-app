package library.spring.controller;

import java.security.Principal;
import java.util.Optional;
import library.spring.entity.Book;
import library.spring.entity.User;
import library.spring.service.BookService;
import library.spring.service.RentService;
import library.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Logger LOGGER = Logger.getLogger(RentController.class);

    @Autowired
    private RentService rentService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping("/rentbook")
    public String rentBook(@RequestParam("bookId") Long bookId, Principal principal) {
        Optional<User> user = userService.getUserByLogin(principal.getName());
        Optional<Book> book = bookService.getBook(bookId);
        try {
            rentService.rentBook(user.get(), book.get());
        } catch (Exception e) {
            LOGGER.error("Error renting the book." + e);
        }
        return "forward:/rent/user-rents";
    }

    @GetMapping("/all-rents")
    public String getAllRents(ModelMap model) {
        model.put("rents", rentService.getAllRents());
        return "all-rents";
    }

    @GetMapping("/user-rents")
    public String getUserRents(ModelMap model, Principal principal) {
        User user = userService.getUserByLogin(principal.getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
        model.put("rents", rentService.getUserActiveRents(user.getUserId()));
        return "user-rents";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam("bookId") Long bookId) {
        rentService.returnBook(bookId);
        return "forward:/rent/user-rents";
    }

    @GetMapping("/rented-users-books")
    public String getBooksRentByUser(ModelMap model, Principal principal) {
        Optional<User> user = userService.getUserByLogin(principal.getName());
        if (user.isPresent()) {
            model.put("books", rentService.getBooksRentByUser(user.get()));
            return "rented-users-books";
        } else {
            LOGGER.error("User not found.");
            model.addAttribute("errorMsg", "Book not found!");
            return "forward:/";
        }
    }
}
