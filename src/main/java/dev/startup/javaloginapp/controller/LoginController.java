package dev.startup.javaloginapp.controller;

import dev.startup.javaloginapp.model.User;
import dev.startup.javaloginapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "login")
public class LoginController  {

    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String viewSignupForm(Model model){
        model.addAttribute("user",new User());
        return "signup_form";
    }

    @PostMapping("/register_process")
    public  String registrationProcess(User user){
        System.out.println(user.getEmail());
        repo.save(user);
        return "register_success";
    }
}
