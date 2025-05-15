package org.example.introspring.service;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.entity.Course;
import org.example.introspring.mapper.CourseMapper;
import org.example.introspring.repository.CourseRepository;
import org.example.introspring.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;  // Añadimos @Autowired

    @Autowired
    private CourseMapper courseMapper;  // Añadimos @Autowired

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
}
