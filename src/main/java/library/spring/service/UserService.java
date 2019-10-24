package library.spring.service;

import java.util.List;
import java.util.Optional;
import library.spring.entity.User;

public interface UserService {
    void addUser(User user);

    Optional<User> getUser(Long userId);

    List<User> getAllUsers();
}
