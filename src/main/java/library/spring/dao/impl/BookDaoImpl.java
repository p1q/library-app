package library.spring.dao.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.TypedQuery;
import library.spring.dao.BookDao;
import library.spring.entity.Author;
import library.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public Book getBook(Long bookId) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book AS b WHERE b.bookId = :bookId", Book.class);
        query.setParameter("bookId", bookId);
        return query.getSingleResult();
    }

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllBooksByAuthor(Author author) {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b.bookId FROM Book AS b INNER JOIN b.authors AS a WHERE a.authorId = :authorId");
        query.setParameter("authorId", author.getAuthorId());
        List<Long> idList = query.getResultList();
        return idList.stream().map(this::getBook).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("FROM Book WHERE title LIKE :title", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
