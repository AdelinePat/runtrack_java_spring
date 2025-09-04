package day3.day3.controller;

import day3.day3.Model.Person;
import day3.day3.Model.PersonRepository;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @Value("${greeting.view}")
    private String viewMessage;

    private final PersonRepository personRepository;

    public ViewController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Display page
    @GetMapping("/viewIGuess")
    public String home(Model model) {
        model.addAttribute("message", viewMessage);
        model.addAttribute("objList", Arrays.asList("Something", "I can't", "stand", "Java"));

        model.addAttribute("validForm", new ValidForm()); // form for adding
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);

        return "view";
    }

    // Add new person
    @PostMapping("/viewIGuess")
    public String handleAddForm(@Valid @ModelAttribute("validForm") ValidForm validForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "view";
        }

        // Save new person
        Person person = new Person(validForm.getWelcome(), validForm.getAge());
        personRepository.save(person);

        // Redirect to GET to reload the page
        return "redirect:/viewIGuess";
    }

    // Update existing person
    @PostMapping("/viewIGuess/{id}/update")
    public String updatePerson(@PathVariable Long id,
                               @RequestParam String personName,
                               @RequestParam Integer personAge) {
        personRepository.findById(id).ifPresent(person -> {
            person.setName(personName);
            person.setAge(personAge);
            personRepository.save(person);
        });
        return "redirect:/viewIGuess";
    }

    // Delete existing person
    @PostMapping("/viewIGuess/{id}/delete")
    public String deletePerson(@PathVariable Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        }
        return "redirect:/viewIGuess";
    }

    // Test endpoint
    @GetMapping("/nothello")
    @ResponseBody
    public String hello() {
        return "JEANNE AU SECOURS ! " + viewMessage;
    }
}
