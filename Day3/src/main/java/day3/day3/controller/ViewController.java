package day3.day3.controller;

import day3.day3.Model.Person;
import day3.day3.Model.PersonRepository;

import day3.day3.Service.PersonService;
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


    private final PersonService personService;

    public ViewController(PersonService personService) {
        this.personService = personService;
    }

    // Display page
    @GetMapping("/viewIGuess")
    public String home(Model model) {
        model.addAttribute("message", viewMessage);
        model.addAttribute("objList", Arrays.asList("Something", "I can't", "stand", "Java"));

        model.addAttribute("validForm", new ValidForm()); // form for adding
        List<Person> persons = personService.getAllPersons();
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
        personService.addPerson(validForm.getWelcome(), validForm.getAge());

        return "redirect:/viewIGuess";
    }

    // Update existing person
    @PostMapping("/viewIGuess/{id}/update")
    public String updatePerson(@PathVariable Long id,
                               @RequestParam String personName,
                               @RequestParam Integer personAge) {
        personService.updatePerson(id, personName, personAge);
        return "redirect:/viewIGuess";
    }

    // Delete existing person
    @PostMapping("/viewIGuess/{id}/delete")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/viewIGuess";
    }

    // Test endpoint
    @GetMapping("/nothello")
    @ResponseBody
    public String hello() {
        return "JEANNE AU SECOURS ! " + viewMessage;
    }
}
