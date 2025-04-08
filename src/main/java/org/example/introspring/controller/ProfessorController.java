package org.example.introspring.controller;

import org.example.introspring.entity.Professor;
import org.example.introspring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/{id}")
    public String professorDetail(@PathVariable("id") Long id, Model model) {
        Professor professor = professorService.getProfessorById(id);
        model.addAttribute("professor", professor);
        return "professor-detail"; // Se busca el template professor-detail.html
    }
}
