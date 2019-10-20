package library.spring.service;

import java.util.List;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;

public interface RentService {
    void rentBook(User user, Book book);

    List<Rent> getAllRents();

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);

    Boolean isBookAvailable(Book book);
}
