package library.spring.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import library.spring.dao.RoleDao;
import library.spring.dao.UserDao;
import library.spring.dto.UserDto;
import library.spring.entity.Role;
import library.spring.entity.User;
import library.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private static final String ROLE_USER = "USER";

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleDao.getRoleByName(ROLE_USER).orElseThrow(()
                -> new NoSuchElementException("The role wasn't found."));
        user.addRole(role);
        userDao.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUser(Long userId) {
        return userDao.getUser(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean isEmailExists(String email) {
        return userDao.isEmailExists(email);
    }

    @Transactional(readOnly = true)
    @Override
    public Boolean isLoginExists(String login) {
        return userDao.isLoginExists(login);
    }
}
