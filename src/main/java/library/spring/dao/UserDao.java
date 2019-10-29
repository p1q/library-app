package library.spring.dao;

import java.util.List;
import java.util.Optional;
import library.spring.entity.User;

public interface UserDao {
    void addUser(User user);

    Optional<User> getUser(Long userId);

    Optional<User> getUserByLogin(String login);

    List<User> getAllUsers();

    void updateUser(User user);

    Boolean isEmailExists(String email);

    Boolean isLoginExists(String login);
}
