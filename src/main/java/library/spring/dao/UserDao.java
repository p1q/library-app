package library.spring.dao;

import java.util.List;
import library.spring.entity.User;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();
}
