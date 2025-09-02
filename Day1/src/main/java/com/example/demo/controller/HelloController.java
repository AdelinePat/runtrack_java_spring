package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


    @Controller
    public class HelloController {

        @GetMapping("/")
        @ResponseBody
        public String hello() {
            return "Hello World !!!!!!!!!!! Spring Boot ça a l'air désagréable";
        }


//    public static void main(String[] args) {
//
//        System.out.println("Hello World");
//        for (String arg : args) {
//            System.out.println(arg);
//        }
//    }
}
