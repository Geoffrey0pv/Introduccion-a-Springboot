package org.example.introspring.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "professor")
    private List<Course> cursos;

    //ToDo: Hacer Getters y Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCursos() {
        return cursos;
    }

    public void setCursos(List<Course> cursos) {
        this.cursos = cursos;
    }
}

