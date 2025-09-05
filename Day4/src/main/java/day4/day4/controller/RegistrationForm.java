package day4.day4.controller;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationForm {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 4, message = "Le mot de passe doit faire au moins 4 caractères")
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
