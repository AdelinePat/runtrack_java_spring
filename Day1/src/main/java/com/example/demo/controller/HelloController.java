package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Value;

    @Controller
    public class HelloController {

        @Value("${greeting.message}")
        private String greetings;

        @GetMapping("/")
        @ResponseBody
        public String hello() {
            return greetings;
        }


//    public static void main(String[] args) {
//
//        System.out.println("Hello World");
//        for (String arg : args) {
//            System.out.println(arg);
//        }
//    }
}




