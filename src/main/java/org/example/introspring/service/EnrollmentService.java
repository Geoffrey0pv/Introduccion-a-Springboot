package org.example.introspring.service;

import org.example.introspring.dto.EnrollmentDTO;

public interface EnrollmentService {
    EnrollmentDTO enroll(Long courseId, Long studentId);
    void deleteEnrollment(Long enrollmentId);
}
