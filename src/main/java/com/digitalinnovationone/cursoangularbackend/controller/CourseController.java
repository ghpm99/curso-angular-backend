package com.digitalinnovationone.cursoangularbackend.controller;


import com.digitalinnovationone.cursoangularbackend.dto.request.CourseDTO;
import com.digitalinnovationone.cursoangularbackend.dto.response.MessageResponseDTO;
import com.digitalinnovationone.cursoangularbackend.exception.CourseNotFoundException;
import com.digitalinnovationone.cursoangularbackend.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {

    private CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createCourse(@RequestBody @Valid CourseDTO courseDTO){
        return courseService.create(courseDTO);
    }

    @GetMapping
    public List<CourseDTO> listAll(){
        return courseService.listAll();
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable Integer id) throws CourseNotFoundException {
        return courseService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) throws CourseNotFoundException {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Integer id, @RequestBody @Valid CourseDTO courseDTO) throws CourseNotFoundException {
        return courseService.updateById(id,courseDTO);
    }

}
