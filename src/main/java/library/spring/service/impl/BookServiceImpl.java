package library.spring.service.impl;

import java.util.List;
import java.util.Optional;

import library.spring.dao.BookDao;
import library.spring.entity.Author;
import library.spring.entity.Book;
import library.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> getBook(Long bookId) {
        return bookDao.getBook(bookId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Transactional
    @Override
    public List<Book> getAllBooksByAuthor(Author author) {
        return bookDao.getAllBooksByAuthor(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }
}
