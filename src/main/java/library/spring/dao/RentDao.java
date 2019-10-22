package library.spring.dao;

import java.util.List;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;

public interface RentDao {
    void rentBook(User user, Book book);

    Rent getRent(User user, Book book);

    List<Rent> getUserActiveRents(User user);

    List<Rent> getAllRents();

    void returnBook(Long bookId);

    List<Book> getBooksRentByUser(User user);

    Boolean isBookAvailable(Book book);
}
