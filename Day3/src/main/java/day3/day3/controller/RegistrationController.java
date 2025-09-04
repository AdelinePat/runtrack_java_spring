package day3.day3.controller;

import day3.day3.Model.User;
import day3.day3.Model.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registrationForm") RegistrationForm form,
                           BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "registration";
        }

        // Check if username already exists
        if (userRepository.findByUsername(form.getUsername()).isPresent()) {
            model.addAttribute("message", "Cet utilisateur existe déjà");
            return "registration";
        }

        // Save new user, default role USER
        User user = new User(form.getUsername(),
                passwordEncoder.encode(form.getPassword()),
                "USER");
        userRepository.save(user);
//        User user = new User(form.getUsername(), form.getPassword(), "USER");
//        userRepository.save(user);

        model.addAttribute("message", "Création du compte avec succès");
        return "registration";
    }
}
