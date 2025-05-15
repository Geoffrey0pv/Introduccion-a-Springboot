package org.example.introspring.mapper;

import org.example.introspring.dto.StudentDTO;
import org.example.introspring.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO studentDTO);
}
