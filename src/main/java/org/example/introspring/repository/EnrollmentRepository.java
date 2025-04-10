package org.example.introspring.repository;

import org.example.introspring.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    // Obtener las inscripciones de un estudiante
    List<Enrollment> findByStudent_Id(Long studentId);

    // Obtener las inscripciones de un curso
    List<Enrollment> findByCourse_Id(Long courseId);

    // Si necesitas obtener cursos, hazlo en CourseRepository o con @Query
}
