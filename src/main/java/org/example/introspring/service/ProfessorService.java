package org.example.introspring.service;

import org.example.introspring.entity.Professor;
import java.util.List;

public interface ProfessorService {
    List<Professor> getAllProfessor();
    Professor getProfessorById(Long id);
}
