package org.example.introspring.controller;

import org.example.introspring.entity.Course;
import org.example.introspring.service.CourseService;
import org.example.introspring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;


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
        return "courses";
    }
    // Muestra la lista de materias
    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses"; // Apunta a courses.html
    }

    // Muestra el detalle de una materia
    @GetMapping("/{id}")
    public String courseDetail(@PathVariable("id") Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "course-detail"; // Apunta a course-detail.html
    }
}
