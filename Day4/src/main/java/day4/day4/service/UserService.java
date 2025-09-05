package day4.day4.service;


import day4.day4.model.User;
import jakarta.persistence.Table;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import day4.day4.model.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository personRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password), "USER");
        User saved = userRepository.save(user);
        System.out.println("Saved user: " + saved.getUsername() + " / " + saved.getPassword());
        return saved;
    }

    public User addUser(String username, String password, String role) {
        User user = new User(username,  passwordEncoder.encode(password), role);
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, String username, String password, String role) {
       return userRepository.findById(id).map(user -> {
           user.setUsername(username);
           user.setPassword(passwordEncoder.encode(password));
           user.setRole(role);
           return userRepository.save(user);
       });

    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}

