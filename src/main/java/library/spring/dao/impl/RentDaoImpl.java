package library.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.Query;
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
    public Optional<Rent> getRent(User user, Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user = :user AND book = :book", Rent.class);
        query.setParameter("user", user);
        query.setParameter("book", book);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<Rent> getUserActiveRents(User user) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user = :user AND active = :active", Rent.class);
        query.setParameter("user", user);
        query.setParameter("active", true);
        return query.getResultList();
    }

    @Override
    public List<Rent> getAllRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent", Rent.class);
        return query.getResultList();
    }

    @Override
    public void returnBook(Long bookId) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Rent SET active = :active WHERE book_id = :bookId");
        query.setParameter("active", false);
        query.setParameter("bookId", bookId);
        query.executeUpdate();
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery(
                "FROM Book b WHERE b.bookId = ANY"
                        + "(SELECT book.bookId FROM Rent WHERE user.userId = :userId)");
        query.setParameter("userId", user.getUserId());
        return query.getResultList();
    }

    @Override
    public Boolean isBookAvailable(Book book) {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE book = :book", Rent.class);
        query.setParameter("book", book);
        return query.getSingleResult().getActive();
    }
}
