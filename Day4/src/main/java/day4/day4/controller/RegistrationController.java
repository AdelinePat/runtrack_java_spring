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

        // Custom error messages
        if (registrationForm.getUsername() == null || registrationForm.getUsername().isBlank()) {
            model.addAttribute("usernameError", "Vous devez entrer un nom d'utilisateur");
        }

        if (registrationForm.getPassword() == null || registrationForm.getPassword().length() < 4) {
            model.addAttribute("passwordError", "Le mot de passe doit faire au moins 4 caractères");
        }

        // Stop if there are errors
        if (model.containsAttribute("usernameError") || model.containsAttribute("passwordError")) {
            return "register";
        }

        // Check if username already exists
        if (userService.findByUsername(registrationForm.getUsername()).isPresent()) {
            model.addAttribute("usernameError", "Nom d'utilisateur déjà utilisé");
            return "register";
        }

        userService.addUser(registrationForm.getUsername(), registrationForm.getPassword());
        model.addAttribute("successMessage", "Compte créé ! Vous pouvez maintenant vous connecter.");
        return "redirect:/login?registered";
    }
}
