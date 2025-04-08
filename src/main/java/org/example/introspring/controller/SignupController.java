package org.example.introspring.controller;

import org.example.introspring.entity.UserTable;
import org.example.introspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new UserTable());
        return "signup"; // Se renderiza signup.html
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute UserTable user) {
        userService.save(user);
        return "redirect:/login";
    }
}
