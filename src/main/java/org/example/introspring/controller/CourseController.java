package org.example.introspring.controller;

import org.example.introspring.entity.Course;
import org.example.introspring.service.CourseService;
import org.example.introspring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorService professorService;


    @GetMapping
    public String index(Model model){
        model.addAttribute("course", new Course());
        model.addAttribute("professors", professorService.getAllProfessor());
        return "course";
    }



}
