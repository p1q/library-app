package library.spring.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import library.spring.validator.EmailExists;
import library.spring.validator.LoginExists;
import library.spring.validator.PasswordMatches;
import library.spring.validator.ValidEmail;

@PasswordMatches
public class UserDto {
    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String surname;

    @NotEmpty
    @NotNull
    @ValidEmail
    @EmailExists
    private String email;

    @NotEmpty
    @NotNull
    @LoginExists
    private String login;

    @NotEmpty
    @NotNull
    private String password;
    private String confirmPassword;

    public UserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
