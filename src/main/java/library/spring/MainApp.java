package library.spring;

import java.util.List;
import library.spring.entity.Book;
import library.spring.entity.User;
import library.spring.config.AppConfig;
import library.spring.service.BookService;
import library.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        BookService bookService = context.getBean(BookService.class);

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId());
            System.out.println("First Name: " + user.getName());
            System.out.println("Last Name: " + user.getSurname());
            System.out.println("Email: " + user.getEmail());
            System.out.println();
        }

        // Add Books
        bookService.add(new Book("Effective Java", 2017, 547.1));
        bookService.add(new Book("Java Concurrency in Practice", 2015, 457.2));
        bookService.add(new Book("Head First Design Patterns", 2014, 614.5));
        bookService.add(new Book("Java: A Beginner’s Guide", 2018, 389.7));

        // Get Books
        List<Book> books = bookService.listBooks();
        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Name: " + book.getName());
            System.out.println("Release Year: " + book.getYear());
            System.out.println("Price: " + book.getPrice());
            System.out.println();
        }

        context.close();
    }
}
