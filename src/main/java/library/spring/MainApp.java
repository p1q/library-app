package library.spring;

import java.util.ArrayList;
import java.util.List;
import library.spring.config.AppConfig;
import library.spring.entity.Author;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;
import library.spring.service.AuthorService;
import library.spring.service.BookService;
import library.spring.service.RentService;
import library.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Add Users
        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Sunil", "Bora", "suni.bora@example.com");
        User user2 = new User("David", "Miller", "david.miller@example.com");
        User user3 = new User("Sameer", "Singh", "sameer.singh@example.com");
        User user4 = new User("Paul", "Smith", "paul.smith@example.com");
        User user5 = new User("Victor", "Karah", "victor.karah@gmail.com");

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);
        userService.addUser(user5);

        // Get Users
        List<User> users = userService.getAllUsers();
        System.out.println("....................................");
        System.out.println("LIST OF USERS:");
        for (User user : users) {
            System.out.printf("User ID: %d, Name: %s, Surname: %s, E-mail: %s%n",
                    user.getUserId(), user.getName(), user.getSurname(), user.getEmail());
        }
        System.out.println("....................................");

        // Add Authors
        Author author1 = new Author("Herbert", "Schildt");
        Author author2 = new Author("Joshua", "Bloch");
        Author author3 = new Author("Bruce", "Eckel");
        Author author4 = new Author("Allen", "Downey");
        Author author5 = new Author("Eric", "Freeman");
        Author author6 = new Author("Robert", "Martin");

        AuthorService authorService = context.getBean(AuthorService.class);
        authorService.addAuthor(author1);
        authorService.addAuthor(author2);
        authorService.addAuthor(author3);
        authorService.addAuthor(author4);
        authorService.addAuthor(author5);
        authorService.addAuthor(author6);

        // Add Books
        List<Author> authorList1 = new ArrayList<>();
        BookService bookService = context.getBean(BookService.class);
        authorList1.add(author1);
        Book book1 = new Book("Effective Java", 2017, 547.1, authorList1);
        bookService.addBook(book1);

        List<Author> authorList2 = new ArrayList<>();
        authorList2.add(author2);
        Book book2 = new Book("Java Concurrency in Practice", 2015, 457.2, authorList2);
        bookService.addBook(book2);

        List<Author> authorList3 = new ArrayList<>();
        authorList3.add(author3);
        Book book3 = new Book("Head First Design Patterns", 2014, 614.5, authorList3);
        bookService.addBook(book3);

        List<Author> authorList4 = new ArrayList<>();
        authorList4.add(author4);
        Book book4 = new Book("Java: A Beginner’s Guide", 2018, 389.7, authorList4);
        bookService.addBook(book4);

        List<Author> authorList5 = new ArrayList<>();
        authorList5.add(author5);
        authorList5.add(author6);
        Book book5 = new Book("Clean Code", 2016, 709.3, authorList5);
        bookService.addBook(book5);

        // Get Books with Authors
        List<Book> books = bookService.getAllBooks();
        System.out.println("....................................");
        System.out.println("LIST OF BOOKS WITH AUTHORS:");
        for (Book book : books) {
            System.out.println();
            System.out.printf("Book ID: %d, Title: %s, Release Year: %d, Price: %s%n",
                    book.getBookId(), book.getTitle(), book.getYear(), book.getPrice());
            System.out.println("Authors' List:");
            for (Author author : book.getAuthors()) {
                System.out.println(author.getName() + " " + author.getSurname());
            }
        }
        System.out.println("....................................");

        // Get Authors
        List<Author> authors = authorService.getAllAuthors();
        System.out.println("....................................");
        System.out.println("LIST OF AUTHORS:");
        for (Author author : authors) {
            System.out.println();
            System.out.printf("Author ID: %d, Name: %s, Surname: %s",
                    author.getAuthorId(), author.getName(), author.getSurname());
        }
        System.out.println();
        System.out.println("....................................");

        // findByTitle Books Test
        books = bookService.findByTitle("Effective Java");
        System.out.println("....................................");
        System.out.println("LIST OF BOOKS WITH AUTHORS FOUND BY NAME \"Effective Java\":");
        for (Book book : books) {
            System.out.println();
            System.out.printf("Book ID: %d, Title: %s, Release Year: %d, Price: %s%n",
                    book.getBookId(), book.getTitle(), book.getYear(), book.getPrice());
            System.out.println("Authors' List:");
            for (Author author : book.getAuthors()) {
                System.out.println(author.getName() + " " + author.getSurname());
            }
        }
        System.out.println("....................................");

        // findByName Authors Test
        authors = authorService.findByName("Bruce");
        System.out.println("....................................");
        System.out.println("LIST OF AUTHORS FOUND BY NAME \"Bruce\":");
        for (Author author : authors) {
            System.out.println();
            System.out.printf("Author ID: %d, Name: %s, Surname: %s",
                    author.getAuthorId(), author.getName(), author.getSurname());
        }
        System.out.println();
        System.out.println("....................................");

        // findByNameAndSurname Authors Test
        authors = authorService.findByNameAndSurname("Eric", "Freeman");
        System.out.println("....................................");
        System.out.println("LIST OF AUTHORS FOUND BY NAME \"Eric\" AND SURNAME \"Freeman\":");
        for (Author author : authors) {
            System.out.println();
            System.out.printf("Author ID: %d, Name: %s, Surname: %s",
                    author.getAuthorId(), author.getName(), author.getSurname());
        }
        System.out.println();
        System.out.println("....................................");

        // rentBook Rent Test
        RentService rentService = context.getBean(RentService.class);
        rentService.rentBook(user1, book1);
        rentService.rentBook(user2, book2);
        rentService.rentBook(user3, book3);
        rentService.rentBook(user4, book4);
        rentService.rentBook(user4, book5);

        // Get Rents
        List<Rent> rents = rentService.getAllRents();
        System.out.println("....................................");
        System.out.println("LIST OF RENTS:");
        for (Rent rent : rents) {
            System.out.printf("Rent ID: %d, Rent Date: %s, User: %s %s, Book: %s,"
                            + " Rent Status: %s%n", rent.getRentId(), rent.getRentDate(),
                    rent.getUser().getName(), rent.getUser().getSurname(),
                    rent.getBook().getTitle(), rent.getActive() ? "ACTIVE" : "CLOSED");
        }
        System.out.println("....................................");

        // returnBook Rent Test
        rentService.returnBook(book2.getBookId());
        rentService.returnBook(book3.getBookId());
        rentService.returnBook(book4.getBookId());

        // Get Rents with returned book
        rents = rentService.getAllRents();
        System.out.println("....................................");
        System.out.println("LIST OF RENTS WITH RETURNED BOOKS:");
        for (Rent rent : rents) {
            System.out.printf("Rent ID: %d, Rent Date: %s, User: %s %s, Book: %s,"
                            + " Rent Status: %s%n", rent.getRentId(), rent.getRentDate(),
                    rent.getUser().getName(), rent.getUser().getSurname(),
                    rent.getBook().getTitle(), rent.getActive() ? "ACTIVE" : "CLOSED");
        }
        System.out.println("....................................");

        // Get Books rented by User 'user1'
        books = rentService.getBooksRentByUser(user4);
        System.out.println("....................................");
        System.out.println("LIST OF BOOKS RENTED BY USER1:");
        for (Book book : books) {
            System.out.println();
            System.out.printf("Book ID: %d, Title: %s, Release Year: %d, Price: %s%n",
                    book.getBookId(), book.getTitle(), book.getYear(), book.getPrice());
            System.out.println("Authors' List:");
            for (Author author : book.getAuthors()) {
                System.out.println(author.getName() + " " + author.getSurname());
            }
        }
        System.out.println("....................................");

        // Test Book availability
        System.out.println("book1 should be available: " + rentService.isBookAvailable(book1));
        System.out.println("book1 should NOT be available: " + rentService.isBookAvailable(book2));

        // Test Book search by Author6
        books = bookService.getAllBooksByAuthor(author6);
        System.out.println("....................................");
        System.out.println("LIST OF FOUND BOOKS BY AUTHOR6:");
        for (Book book : books) {
            System.out.printf("Book ID: %d, Title: %s, Release Year: %d, Price: %s%n",
                    book.getBookId(), book.getTitle(), book.getYear(), book.getPrice());
        }
        System.out.println("....................................");

        context.close();
    }
}
