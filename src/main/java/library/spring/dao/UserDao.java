package library.spring.dao;

import library.spring.entity.User;
import java.util.List;

public interface UserDao {
    List<User> listUsers();

    void add(User user);
}
