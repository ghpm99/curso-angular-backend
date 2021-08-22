package com.digitalinnovationone.cursoangularbackend.repositories;

import com.digitalinnovationone.cursoangularbackend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
