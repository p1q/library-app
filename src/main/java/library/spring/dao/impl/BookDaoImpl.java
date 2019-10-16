package library.spring.dao.impl;

import java.util.List;
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
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public List<Book> listBooks() {
        @SuppressWarnings("unchecked")
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book");
        return query.getResultList();
    }

    @Override
    public List<Book> findByName(String name) {
        return null;
    }

    @Override
    public List<Book> findByAuthor(Author author) {
        return null;
    }
}
