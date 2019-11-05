package library.spring.dao;

import java.util.List;
import java.util.Optional;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;

public interface RentDao {
    void rentBook(User user, Book book);

    Optional<Rent> getRent(User user, Book book);

    void deleteUser(User user);

    List<Rent> getUserActiveRents(User user);

    List<Rent> getAllRents();

    void returnBook(Long bookId);

    List<Book> getBooksRentByUser(User user);

    Boolean isBookAvailable(Book book);
}
