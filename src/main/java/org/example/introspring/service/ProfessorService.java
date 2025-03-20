package org.example.introspring.service;

import org.example.introspring.entity.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    List<Professor> getAllProfessor();
}
