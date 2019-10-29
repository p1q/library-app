package library.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import library.spring.dto.UserDto;
import library.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String registerPage() {
        return "register";
    }

    @PostMapping
    public String register(@Valid @ModelAttribute("user") UserDto userDto,
                           BindingResult result, ModelMap model) {
        if (!result.hasErrors()) {
            userService.addUser(userDto);
            return "registered";
        }
        List<String> errors = result.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        model.addAttribute("errors", errors);
        return "register-failed";
    }

    @GetMapping("/register-failed")
    public String registerFailed() {
        return "register-failed";
    }
}
