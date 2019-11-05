package library.spring.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import library.spring.dto.UserDto;
import library.spring.validator.PasswordMatches;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        UserDto user = (UserDto) object;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
