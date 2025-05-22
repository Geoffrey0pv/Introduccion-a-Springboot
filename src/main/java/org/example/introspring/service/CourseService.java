package org.example.introspring.service;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.dto.StudentDTO;
import org.example.introspring.entity.Course;

import java.util.List;

public interface CourseService {


    CourseDTO createCourse(CourseDTO courseDTO);

    List<CourseDTO> getAllCourses();

    Course getCourseById(long id);

    void deleteCourse(long id);

    List<StudentDTO> getStudentsByCourse(Long courseId);

    List<CourseDTO> getCoursesWithStudentCount();

}
