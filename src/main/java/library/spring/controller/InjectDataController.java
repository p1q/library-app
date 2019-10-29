package library.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import library.spring.config.AppConfig;
import library.spring.dao.RentDao;
import library.spring.entity.Author;
import library.spring.entity.Book;
import library.spring.entity.Role;
import library.spring.entity.User;
import library.spring.service.AuthorService;
import library.spring.service.BookService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
@Transactional
@EnableTransactionManagement
public class InjectDataController {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RentDao rentDao;

    @GetMapping("/data")
    public String injectDemoData(Model model) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Add Admin, User and Roles - ADMIN and USER
        Role adminRole = new Role("ADMIN");
        Role userRole = new Role("USER");
        User admin = new User("Admin", "Admin", "admin@mail.com", "admin",
                "$2a$10$5yc7SlKRMMdrqTdRC/1Aye5PPfuOvb3ABDEnwXYBLePIharhScsGW");
        User user = new User("User", "User", "user@mail.com", "user",
                "$2a$10$5yc7SlKRMMdrqTdRC/1Aye5PPfuOvb3ABDEnwXYBLePIharhScsGW");
        admin.addRole(adminRole);
        admin.addRole(userRole);
        user.addRole(userRole);
        sessionFactory.getCurrentSession().save(admin);
        sessionFactory.getCurrentSession().save(user);

        // Add Users
        User user1 = new User("Sunil", "Bora", "suni.bora@example.com", "sunil", "1");
        User user2 = new User("David", "Miller", "david.miller@example.com", "david", "1");
        User user3 = new User("Sameer", "Singh", "sameer.singh@example.com", "sameer", "1");
        User user4 = new User("Paul", "Smith", "paul.smith@example.com", "paul", "1");
        User user5 = new User("Victor", "Karah", "victor.karah@gmail.com", "victor", "1");
        sessionFactory.getCurrentSession().save(user1);
        sessionFactory.getCurrentSession().save(user2);
        sessionFactory.getCurrentSession().save(user3);
        sessionFactory.getCurrentSession().save(user4);
        sessionFactory.getCurrentSession().save(user5);

        String queryString = "INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);";
        Query query = sessionFactory.getCurrentSession().createNativeQuery(queryString);
        query.executeUpdate();
        queryString = "INSERT INTO users_roles (user_id, role_id) VALUES (4, 2);";
        query = sessionFactory.getCurrentSession().createNativeQuery(queryString);
        query.executeUpdate();
        queryString = "INSERT INTO users_roles (user_id, role_id) VALUES (5, 2);";
        query = sessionFactory.getCurrentSession().createNativeQuery(queryString);
        query.executeUpdate();
        queryString = "INSERT INTO users_roles (user_id, role_id) VALUES (6, 2);";
        query = sessionFactory.getCurrentSession().createNativeQuery(queryString);
        query.executeUpdate();
        queryString = "INSERT INTO users_roles (user_id, role_id) VALUES (7, 2);";
        query = sessionFactory.getCurrentSession().createNativeQuery(queryString);
        query.executeUpdate();

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

        // Add Books & Authors
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

        // Add Rents
        rentDao.rentBook(user1, book1);
        rentDao.rentBook(user2, book2);
        rentDao.rentBook(user3, book3);
        rentDao.rentBook(user4, book4);
        rentDao.rentBook(user4, book5);

        // Return books
        rentDao.returnBook(book2.getBookId());
        rentDao.returnBook(book3.getBookId());
        rentDao.returnBook(book4.getBookId());

        model.addAttribute("message", "Demo data injected successfully!");
        return "forward:/";
    }
}
