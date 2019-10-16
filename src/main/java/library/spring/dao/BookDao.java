package library.spring.dao;

import java.util.List;
import library.spring.entity.Author;
import library.spring.entity.Book;

public interface BookDao {
    List<Book> listBooks();

    void add(Book book);

    List< Book> findByName(String name);

    List< Book> findByAuthor(Author author);
}
