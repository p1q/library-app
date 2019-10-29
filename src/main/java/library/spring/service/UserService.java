package library.spring.service;

import java.util.List;
import java.util.Optional;
import library.spring.dto.UserDto;
import library.spring.entity.User;

public interface UserService {
    void addUser(UserDto userDto);

    Optional<User> getUser(Long userId);

    List<User> getAllUsers();

    void updateUser(User user);

    Optional<User> getUserByLogin(String login);

    Boolean isEmailExists(String email);

    Boolean isLoginExists(String login);
}
