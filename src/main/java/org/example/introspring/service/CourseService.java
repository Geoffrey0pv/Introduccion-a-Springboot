package org.example.introspring.service;

import org.example.introspring.entity.Course;

import java.util.List;

public interface CourseService {


    Course createCourse(Course course);

    List<Course> listCourseOfStudent(long studentId);

    List<Course> getAllCourses();

    Course getCourseById(long id);

    void deleteCourse(long id);

}
