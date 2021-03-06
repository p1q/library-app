package library.spring.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import library.spring.security.EmailExistsValidator;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailExistsValidator.class)
public @interface EmailExists {
    String message() default "E-mail already registered";
    Class<?>[] groups() default {}; 
    Class<? extends Payload>[] payload() default {};
}
