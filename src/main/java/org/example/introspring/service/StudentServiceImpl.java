package org.example.introspring.service;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.dto.StudentDTO;
import org.example.introspring.entity.Student;
import org.example.introspring.mapper.CourseMapper;
import org.example.introspring.mapper.StudentMapper;
import org.example.introspring.repository.EnrollmentRepository;
import org.example.introspring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.example.introspring.entity.Enrollment;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Value("${app.pagination.size}")
    private int pageSize;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .toList();
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

    @Override
    public StudentDTO registerStudent(StudentDTO dto) {
        Student entity = studentMapper.toEntity(dto);
        entity = studentRepository.save(entity);
        return studentMapper.toDTO(entity);
    }

    @Override
    public List<CourseDTO> getCoursesByStudent(Long studentId) {

        studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
        return enrollmentRepository.findByStudent_Id(studentId)
                .stream()
                .map(Enrollment::getCourse)
                .map(courseMapper::toDTO)
                .toList();
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));

        if (dto.getName() != null && !dto.getName().isBlank()) {
            student.setName(dto.getName());
        }
        if (dto.getProgram() != null && !dto.getProgram().isBlank()) {
            student.setProgram(dto.getProgram());
        }
        return studentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> findByProgram(String program) {
        return studentRepository.findByProgramIgnoreCase(program)
                .stream()
                .map(studentMapper::toDTO)
                .toList();
    }
}
