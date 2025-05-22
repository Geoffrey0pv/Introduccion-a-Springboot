package org.example.introspring.service;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.dto.StudentDTO;
import org.example.introspring.entity.Course;
import org.example.introspring.entity.Enrollment;
import org.example.introspring.mapper.CourseMapper;
import org.example.introspring.mapper.StudentMapper;
import org.example.introspring.repository.CourseRepository;
import org.example.introspring.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO){
        var entity = courseMapper.toEntity(courseDTO);
        if(entity.getName() == null || entity.getName().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del curso es obligatorio");
        }
        Course courseEntity = courseRepository.save(entity);
        return courseMapper.toDTO(courseEntity);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(entity -> courseMapper.toDTO(entity)).toList();
    }

    @Override
    public Course getCourseById(long id){
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public void deleteCourse(long id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Course not found");
        }
    }

    @Override
    public List<StudentDTO> getStudentsByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Course with id " + courseId + " not found"));

        return course.getEnrollments()
                .stream()
                .map(Enrollment::getStudent)    
                .map(studentMapper::toDTO)
                .toList();
    }

    @Override
    public List<CourseDTO> getCoursesWithStudentCount() {
        return courseRepository.fetchCourseWithStudentCount().stream().map(entity -> {
            CourseDTO courseDTO = courseMapper.toDTO(entity);
            courseDTO.setCountStudents(entity.getEnrollments().size());
            return courseDTO;
        }).toList();
    }
}
