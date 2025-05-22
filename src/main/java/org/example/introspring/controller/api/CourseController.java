package org.example.introspring.controller.api;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.dto.StudentDTO;
import org.example.introspring.entity.Student;
import org.example.introspring.mapper.StudentMapper;
import org.example.introspring.service.CourseService;
import org.example.introspring.service.EnrollmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/courses")
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
    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(
            @RequestBody CourseDTO dto,
            UriComponentsBuilder uriBuilder) {

        CourseDTO created = courseService.createCourse(dto);

        URI location = uriBuilder
                .path("/courses/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }
    @GetMapping("/count-students")
    public ResponseEntity<List<CourseDTO>> listCoursesWithCount() {
        var result = courseService.getCoursesWithStudentCount();
        return ResponseEntity.ok(result);
    }
}
