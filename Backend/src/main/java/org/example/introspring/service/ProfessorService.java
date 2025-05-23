package org.example.introspring.service;

import org.example.introspring.entity.Professor;
import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    List<Professor> getAllProfessor();
    Optional<Professor> getProfessorById(Long id);
}
