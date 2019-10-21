package library.spring.controller;

import library.spring.util.InjectDemoData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String showIndex() {
        InjectDemoData.injectDemoData();
        return "index";
    }
}
