package day2.demoDay2.Controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @Value("${greeting.view}")
    private String viewMessage;


    @GetMapping("/viewIGuess")
    public String home(Model model) {
        model.addAttribute("message", viewMessage);
        String[] objList = {"Something", "I can't", "stand", "Java"};
        model.addAttribute("objList", objList);

        model.addAttribute("validForm", new ValidForm());
        return "view";
    }

//    @PostMapping("/viewIGuess")
//    public String handleForm(@RequestParam("welcome") String name,
//                             @RequestParam("else") String anotherString,
//                             Model model) {
//        model.addAttribute("message", viewMessage);
//        model.addAttribute("welcomeMessage", "Bienvenue, " + name + " !!! " + anotherString);
//        model.addAttribute("objList", Arrays.asList("Something", "I can't", "stand", "Java"));
//        return "view"; // same template
//    }

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

        model.addAttribute("welcomeMessage",
                "Bienvenue, " + validForm.getWelcome() + " !!! " + validForm.getAnotherField());

        return "view"; // same template
    }

    @GetMapping("/nothello")
    @ResponseBody
    public String hello() {
        return "JEANNE AU SECOURS ! " + viewMessage;
    }
}