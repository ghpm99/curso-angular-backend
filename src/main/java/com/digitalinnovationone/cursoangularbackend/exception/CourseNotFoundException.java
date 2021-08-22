package com.digitalinnovationone.cursoangularbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends Exception{
    public CourseNotFoundException(Integer id){
        super("Course not found with ID " + id);
    }
}
