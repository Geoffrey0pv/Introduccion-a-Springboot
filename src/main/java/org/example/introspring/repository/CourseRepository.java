package org.example.introspring.repository;

import org.example.introspring.entity.Course;
import org.example.introspring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByEnrollmentsStudent(Student student);

    List<Course> findAll();

    Optional<Course> findById(Long number);

    void deleteById(Long number);

    boolean existsById(Long number);

    @Query("""
           SELECT c.id      AS id,
                  c.name    AS name,
                  COUNT(e)  AS studentCount
           FROM   Course c
           LEFT JOIN c.enrollments e
           GROUP BY c.id, c.name
           ORDER BY c.name
           """)
    List<Course> fetchCourseWithStudentCount();
}
