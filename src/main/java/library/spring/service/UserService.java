package library.spring.service;

import java.util.List;
import library.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
