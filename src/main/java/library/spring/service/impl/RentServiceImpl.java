package library.spring.service.impl;

import java.util.List;
import java.util.Optional;
import library.spring.dao.RentDao;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;
import library.spring.exceptions.UserNotFoundException;
import library.spring.service.BookService;
import library.spring.service.RentService;
import library.spring.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {
    private static final Logger LOGGER = Logger.getLogger(RentServiceImpl.class);

    @Autowired
    private RentDao rentDao;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Transactional
    @Override
    public void rentBook(User user, Book book) {
        rentDao.rentBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> getUserActiveRents(Long userId) {
        Optional<User> user = userService.getUser(userId);
        if (user.isPresent()) {
            return rentDao.getUserActiveRents(user.get());
        } else {
            LOGGER.error("User not found.");
            throw new UserNotFoundException("User not found.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> getAllRents() {
        return rentDao.getAllRents();
    }

    @Transactional
    @Override
    public void returnBook(Long bookId) {
        rentDao.returnBook(bookId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksRentByUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean isBookAvailable(Book book) {
        return rentDao.isBookAvailable(book);
    }
}
