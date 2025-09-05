package day4.day4.controller;

import day4.day4.model.User;
import day4.day4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute RegistrationForm registrationForm,
                               BindingResult bindingResult,
                               Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        if (userService.findByUsername(registrationForm.getUsername()).isPresent()) {
            model.addAttribute("usernameError", "Nom d'utilisateur déjà utilisé");
            return "register";
        }

        userService.addUser(registrationForm.getUsername(), registrationForm.getPassword());
        model.addAttribute("successMessage", "Compte créé ! Vous pouvez maintenant vous connecter.");
        return "redirect:/login?registered"; // redirect to manual login page
    }
}
