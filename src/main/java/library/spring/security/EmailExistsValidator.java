package library.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import library.spring.service.UserService;
import library.spring.validator.EmailExists;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return !(userService.isEmailExists(email));
    }
}
