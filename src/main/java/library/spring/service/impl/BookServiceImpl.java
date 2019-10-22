package library.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import library.spring.dao.BookDao;
import library.spring.entity.Author;
import library.spring.entity.Book;
import library.spring.service.AuthorService;
import library.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorService authorService;

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

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByAuthor(String searchString) {
        List<Author> allAuthors = authorService.getAllAuthors();
        List<Author> foundAuthors = new ArrayList<>();
        allAuthors.forEach(a -> {
            String name = a.getName();
            String surname = a.getSurname();
            String author = String.format("%s %s %s %s", name, surname, surname, name);
            if (author.contains(searchString)) {
                foundAuthors.add(a);
            }
        });
        return bookDao.findByAuthor(foundAuthors);
    }
}
