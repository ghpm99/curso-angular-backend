package com.digitalinnovationone.cursoangularbackend.service;

import com.digitalinnovationone.cursoangularbackend.dto.mapper.CourseMapper;
import com.digitalinnovationone.cursoangularbackend.dto.request.CourseDTO;
import com.digitalinnovationone.cursoangularbackend.dto.response.MessageResponseDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Course;
import com.digitalinnovationone.cursoangularbackend.exception.CourseNotFoundException;
import com.digitalinnovationone.cursoangularbackend.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseService {

    private CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public MessageResponseDTO create(CourseDTO courseDTO){
        Course courseToSave = courseMapper.toModel(courseDTO);
        Course savedCourse = courseRepository.save(courseToSave);
        return createMessageResponse(savedCourse.getId(), "Created course with ID :");
    }

    public List<CourseDTO> listAll(){
        List<Course> allCourse = courseRepository.findAll();

        return allCourse.stream().map(courseMapper :: toDTO).collect(Collectors.toList());
    }

    public CourseDTO findById(Integer id) throws CourseNotFoundException {
        Course course = verifyIfExists(id);
        return courseMapper.toDTO(course);
    }

    public void delete(Integer id) throws CourseNotFoundException {
        verifyIfExists(id);
        courseRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Integer id, @Valid CourseDTO courseDTO) throws CourseNotFoundException {
        verifyIfExists(id);

        Course courseToUpdate = courseMapper.toModel(courseDTO);
        Course updatedCourse = courseRepository.save(courseToUpdate);
        return createMessageResponse(updatedCourse.getId(), "Update course with ID:");
    }



    private Course verifyIfExists(Integer id) throws CourseNotFoundException {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(int id, String message) {
        return MessageResponseDTO.builder().message(message + id).build();
    }
}
