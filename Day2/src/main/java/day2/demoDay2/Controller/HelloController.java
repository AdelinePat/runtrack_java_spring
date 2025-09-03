package day2.demoDay2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.ui.Model;

@Controller
public class HelloController {

    @Value("${greeting.message}")
    private String greetingMessage;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", greetingMessage);
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return greetingMessage + " | ";
    }
}