package org.example.introspring.dto;

public class CourseDTO {
    private long id;
    private String name;
    private Long professorId;
    private int countStudents;

    public int getCountStudents() {return countStudents;}

    public void setCountStudents(int countStudents) {this.countStudents = countStudents;}

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

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }
}
