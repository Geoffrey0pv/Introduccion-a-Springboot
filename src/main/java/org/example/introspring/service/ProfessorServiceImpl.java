package org.example.introspring.service;

import org.example.introspring.entity.Professor;
import org.example.introspring.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<Professor> getAllProfessor() {
        // Simplemente delegamos en la operación findAll() del repositorio.
        return professorRepository.findAll();
    }
}
