package com.digitalinnovationone.cursoangularbackend.dto.mapper;

import com.digitalinnovationone.cursoangularbackend.dto.request.CourseDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toModel(CourseDTO courseDTO);

    CourseDTO toDTO(Course course);

}
