package org.example.introspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Hello desde Computación en Internet 2");
        return "home"; // Renderiza home.html en src/main/resources/templates
    }
}

