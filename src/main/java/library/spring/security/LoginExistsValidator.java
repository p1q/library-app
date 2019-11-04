package library.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import library.spring.validator.LoginExists;
import library.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginExistsValidator implements ConstraintValidator<LoginExists, String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String login, ConstraintValidatorContext context) {
        return !(userService.isLoginExists(login));
    }
}
