package library.spring.service;

import java.util.List;
import library.spring.entity.Book;

public interface BookService {
    void add(Book book);

    List<Book> listBooks();
}
