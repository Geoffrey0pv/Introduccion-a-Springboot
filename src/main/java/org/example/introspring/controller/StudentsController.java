package org.example.introspring.controller;


import org.example.introspring.entity.Student;
import org.example.introspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    // Muestra la lista de estudiantes
    @GetMapping("/students")
    public String listStudents(Model model) {
        var student = studentService.getAll();
        model.addAttribute("students", student);
        return "students"; // Apunta al template students.html
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable("id") int id){
        var student = studentService.findByCode(id);
        model.addAttribute("student", student);
        return "studentdetail";
    }

}
