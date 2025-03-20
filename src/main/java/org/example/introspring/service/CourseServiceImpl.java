package org.example.introspring.service;

import org.example.introspring.entity.Course;
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

    @Override
    public Course createCourse(Course course){
        if(course.getName() == null || course.getName().trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del curso es obligatorio");
        }
        return courseRepository.save(course);
    }

    @Override
    public List<Course> listCourseOfStudent(long studentId){
        var enrollments = enrollmentRepository.findByStudent_Id(studentId);
        return enrollments.stream()
                .map(enrollment -> enrollment.getCourse())
                .toList();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
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
