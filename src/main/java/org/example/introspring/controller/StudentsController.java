package org.example.introspring.controller;


import org.example.introspring.entity.Student;
import org.example.introspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/student")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String student(Model model){
        var students = studentService.getAllStudents();
        model.addAttribute("greeting", "Hola Mundo");
        model.addAttribute("students", students);
        model.addAttribute("student", new Student());
        return "Student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute Student student){
        //almacenar
        studentService.createStudent(student);
        return "redirect:/student";
    }

}
