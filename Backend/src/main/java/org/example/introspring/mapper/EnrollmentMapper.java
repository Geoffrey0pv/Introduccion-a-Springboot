package org.example.introspring.mapper;

import org.example.introspring.dto.EnrollmentDTO;
import org.example.introspring.entity.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    @Mapping(source = "course.id",   target = "courseId")
    @Mapping(source = "student.id",  target = "studentId")
    EnrollmentDTO toDTO(Enrollment e);
}

