package org.example.introspring.repository;

import org.example.introspring.entity.Course;
import org.example.introspring.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>  {
    Professor findById(Long id);
}
