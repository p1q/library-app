package library.spring.service;

import java.util.List;
import library.spring.entity.User;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();
}
