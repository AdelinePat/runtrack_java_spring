package day2.demoDay2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ViewController {

    @Value("${greeting.view}")
    private String viewMessage;

//    @Value("${greeting.objList}")
//    private List<String> objList;

    @GetMapping("/viewIGuess")
    public String home(Model model) {
        model.addAttribute("message", viewMessage);
        String[] objList = {"Something", "I can't", "stand", "Java"};
        model.addAttribute("objList", objList);
        return "view";
    }

    @GetMapping("/nothello")
    @ResponseBody
    public String hello() {
        return "JEANNE AU SECOURS ! " + viewMessage;
    }
}