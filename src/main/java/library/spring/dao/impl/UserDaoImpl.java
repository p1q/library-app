package library.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import library.spring.dao.UserDao;
import library.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE userId = :userId", User.class);
        query.setParameter("userId", userId);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE login = :login", User.class);
        query.setParameter("login", login);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public Boolean isEmailExists(String email) {
        TypedQuery query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(u) FROM User u WHERE email = :email");
        query.setParameter("email", email);
        return (Long)(query.getSingleResult()) != 0;
    }

    @Override
    public Boolean isLoginExists(String login) {
        TypedQuery query = sessionFactory.getCurrentSession()
                .createQuery("SELECT COUNT(u) FROM User u WHERE login = :login");
        query.setParameter("login", login);
        return (Long)(query.getSingleResult()) != 0;
    }
}
