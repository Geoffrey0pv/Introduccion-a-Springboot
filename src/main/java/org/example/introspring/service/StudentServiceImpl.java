package org.example.introspring.service;

import org.example.introspring.entity.Student;
import org.example.introspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        System.out.println("GET ALL STUDENTS");
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByProgram(String program) {
        return studentRepository.findByProgram(program);
    }

    @Override
    public Page<Student> findAll(int page) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return studentRepository.findAll(pageable);
    }
    @Override
    public Student findByCode(int code) {
        return studentRepository.getStudentById(code);
    }
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
