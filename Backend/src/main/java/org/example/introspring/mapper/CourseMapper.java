package org.example.introspring.mapper;

import org.example.introspring.dto.CourseDTO;
import org.example.introspring.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "professor.id", target = "professorId")
    CourseDTO toDTO(Course course);

    @Mapping(source = "professorId", target = "professor.id")
    Course toEntity(CourseDTO dto);

    @Mapping(source = "professorId", target = "professor.id")
    void updateEntityFromDTO(CourseDTO dto, @MappingTarget Course course);
}