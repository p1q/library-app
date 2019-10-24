package library.spring.exceptions;

public class RequiredFieldsNotFilled extends Exception {
    public RequiredFieldsNotFilled(String message) {
        super(message);
    }
}
