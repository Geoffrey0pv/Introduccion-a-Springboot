package org.example.introspring.service;

import org.example.introspring.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.introspring.dto.EnrollmentDTO;
import org.example.introspring.entity.Course;
import org.example.introspring.entity.Enrollment;
import org.example.introspring.entity.Student;
import org.example.introspring.mapper.EnrollmentMapper;
import org.example.introspring.repository.EnrollmentRepository;
import org.example.introspring.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository    studentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private EnrollmentMapper     enrollmentMapper;

    @Override
    public EnrollmentDTO enroll(Long courseId, Long studentId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(()  -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

        //Evita matricular dos veces
        enrollmentRepository.findByCourse_IdAndStudent_Id(courseId, studentId)
                .ifPresent(e -> { throw new ResponseStatusException(
                        HttpStatus.CONFLICT,
                        "Student " + studentId + " is already enrolled in course " + courseId);
                });

        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setCourse(course);
        newEnrollment.setStudent(student);

        Enrollment saved = enrollmentRepository.save(newEnrollment);
        return enrollmentMapper.toDTO(saved);
    }

    @Override
    public void deleteEnrollment(Long enrollmentId) {
        if (!enrollmentRepository.existsById(enrollmentId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
        }
        enrollmentRepository.deleteById(enrollmentId);
    }
}
