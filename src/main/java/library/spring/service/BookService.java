package library.spring.service;

import java.util.List;
import library.spring.entity.Author;
import library.spring.entity.Book;

public interface BookService {
    void addBook(Book book);

    Book getBook(Long bookId);

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(Author author);

    List<Book> findByTitle(String title);
}
