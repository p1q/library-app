package library.spring.service.impl;

import java.util.List;
import library.spring.dao.RentDao;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;
import library.spring.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public void rentBook(User user, Book book) {
        rentDao.rentBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Rent> getAllRents() {
        return rentDao.getAllRents();
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        rentDao.returnBook(user, book);
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
