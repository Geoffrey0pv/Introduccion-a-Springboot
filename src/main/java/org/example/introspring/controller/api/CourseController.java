package org.example.introspring.controller.api;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.dto.StudentDTO;
import org.example.introspring.entity.Student;
import org.example.introspring.mapper.StudentMapper;
import org.example.introspring.service.CourseService;
import org.example.introspring.service.EnrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @Autowired
    private EnrollmentsService enrollmentsService;

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        var coursesList = courseService.getAllCourses();
        return ResponseEntity.status(200).body(coursesList);
    }

    // Endpoint: GET /courses/{id}/students
    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<StudentDTO>> getStudentsByCourse(@PathVariable("courseId") long courseId) {
        // Utilizamos el servicio para obtener los estudiantes inscritos en el curso
        List<Student> students = enrollmentsService.getStudentsEnrolledInCourse(courseId);

        // Convertimos las entidades a DTO
        List<StudentDTO> studentDTOs = students.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
        // Devolvemos la lista de estudiantes como respuesta
        return ResponseEntity.ok(studentDTOs);
    }
}
