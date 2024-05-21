package dev.startup.javaloginapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController  {

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }
}
