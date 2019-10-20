package library.spring.dao;

import java.util.List;
import library.spring.entity.Author;
import library.spring.entity.Book;

public interface BookDao {
    void addBook(Book book);

    Book getBook(Long bookId);

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(Author author);

    List<Book> findByTitle(String title);
}
