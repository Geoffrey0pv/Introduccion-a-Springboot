package org.example.introspring.repository;

import org.example.introspring.entity.Course;
import org.example.introspring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByEnrollmentsStudent(Student student);

    List<Course> findAll();

    Optional<Course> findById(long number);

    void deleteById(long number);

    Boolean existsById(long number);
}
