package org.example.introspring.service;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.entity.Student;
import org.springframework.data.domain.Page;
import java.util.List;
import org.example.introspring.dto.StudentDTO;

public interface StudentService {
    void createStudent(Student student);
    List<StudentDTO> getAllStudents();
    List<Student> getStudentsByProgram(String program);
    Page<Student> findAll(int page);
    Student findByCode(int code);
    List<Student> getAll();
    StudentDTO registerStudent(StudentDTO dto);
    List<CourseDTO> getCoursesByStudent(Long studentId);
    StudentDTO updateStudent(Long id, StudentDTO dto);
    List<StudentDTO> findByProgram(String program);
}
