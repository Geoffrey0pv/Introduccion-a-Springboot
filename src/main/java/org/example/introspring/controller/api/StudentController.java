package org.example.introspring.controller.api;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.dto.StudentDTO;
import org.example.introspring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(
            @RequestBody StudentDTO dto,
            UriComponentsBuilder uriBuilder) {

        StudentDTO created = studentService.registerStudent(dto);

        URI location = uriBuilder
                .path("/students/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudent(@PathVariable Long id) {
        List<CourseDTO> courses = studentService.getCoursesByStudent(id);
        return ResponseEntity.ok(courses);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDTO dto) {
        if (dto.getName() == null && dto.getProgram() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "At least one field (name or program) must be provided");
        }
        StudentDTO updated = studentService.updateStudent(id, dto);
        return ResponseEntity.ok(updated);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> listStudents(
            @RequestParam(required = false) String program) {

        List<StudentDTO> result = (program == null || program.isBlank())
                ? studentService.getAllStudents()
                : studentService.findByProgram(program);

        return ResponseEntity.ok(result);
    }
}

