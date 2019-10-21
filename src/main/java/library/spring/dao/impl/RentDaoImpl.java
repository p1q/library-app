package library.spring.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import library.spring.dao.RentDao;
import library.spring.entity.Book;
import library.spring.entity.Rent;
import library.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void rentBook(User user, Book book) {
        sessionFactory.getCurrentSession().save(new Rent(user, book));
    }

    @Override
    public Rent getRent(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user = :user AND book = :book", Rent.class);
        query.setParameter("user", user);
        query.setParameter("book", book);
        return query.getSingleResult();
    }

    @Override
    public List<Rent> getAllRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public void returnBook(User user, Book book) {
        Rent rent = getRent(user, book);
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user = :user AND active = :active", Rent.class);
        query.setParameter("user", user);
        query.setParameter("active", true);
        return query.getResultList().stream().map(Rent::getBook).collect(Collectors.toList());
    }

    @Override
    public Boolean isBookAvailable(Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE book = :book", Rent.class);
        query.setParameter("book", book);
        return query.getSingleResult().getActive();
    }
}
