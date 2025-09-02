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
            int a = 2+2;
            return greetings + "va te faire AAAAG  fuck va te faire mettre foutre putain";
        }
}




