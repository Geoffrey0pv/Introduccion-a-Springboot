package org.example.introspring.repository;

import org.example.introspring.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent_Id(Long studentId);

    List<Enrollment> findByCourse_Id(Long courseId);

    Optional<Enrollment> findByCourse_IdAndStudent_Id(Long courseId, Long studentId);
}
