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

    @GetMapping("/viewIGuess")
    public String home(Model model) {
        model.addAttribute("message", viewMessage);
        String[] objList = {"Something", "I can't", "stand", "Java"};
        model.addAttribute("objList", objList);

        model.addAttribute("validForm", new ValidForm());

        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);

        return "view";
    }

    @PostMapping("/viewIGuess")
    public String handleForm(@Valid @ModelAttribute("validForm") ValidForm validForm,
                             BindingResult bindingResult,
                             Model model) {
        model.addAttribute("message", viewMessage);
        model.addAttribute("objList", Arrays.asList("Something", "I can't", "stand", "Java"));

        if (bindingResult.hasErrors()) {
            // If validation fails, return the same page with errors
            return "view";
        }

        // Save the new person into DB
        Person person = new Person(validForm.getWelcome(), validForm.getAge());
        personRepository.save(person);

        // After saving, reload all persons from DB
        List<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        Person thisPerson = personRepository.findByName("Something");
        if (thisPerson != null) {
            model.addAttribute("welcomeMessage",
                    "Bienvenue, " + validForm.getWelcome() + " !!! " + validForm.getAnotherField() + " ---- Personne récupérée de la db si existe : " + thisPerson.getName() + " " + thisPerson.getAge());
        } else {
            model.addAttribute("welcomeMessage",
                    "Bienvenue, " + validForm.getWelcome() + " !!! " + validForm.getAnotherField());
        }


        return "view"; // same template
    }

    @GetMapping("/nothello")
    @ResponseBody
    public String hello() {
        return "JEANNE AU SECOURS ! " + viewMessage;
    }
}