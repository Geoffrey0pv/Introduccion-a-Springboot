package org.example.introspring.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.example.introspring.dto.EnrollmentDTO;
import org.example.introspring.service.EnrollmentService;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("api/v1/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/courses/{courseId}/students/{studentId}")
    public ResponseEntity<EnrollmentDTO> enrollStudent(
            @PathVariable Long courseId,
            @PathVariable Long studentId,
            UriComponentsBuilder uriBuilder) {

        EnrollmentDTO dto = enrollmentService.enroll(courseId, studentId);

        URI location = uriBuilder
                .path("/enrollments/{id}")
                .buildAndExpand(dto.getId())
                .toUri();

        return ResponseEntity.created(location).body(dto);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('PROFESSOR','ADMIN')")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();   // 204 No Content
    }
}

