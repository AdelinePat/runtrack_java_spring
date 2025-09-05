package day4.day4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@Controller
public class AppController {

    @GetMapping("/app")
    public String home(Model model, Authentication auth) {
        model.addAttribute("welcomeMessage", "Bienvenu : " + auth.getName());
        return "app";
    }
}
