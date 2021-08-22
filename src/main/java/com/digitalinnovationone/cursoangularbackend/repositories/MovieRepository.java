package com.digitalinnovationone.cursoangularbackend.repositories;

import com.digitalinnovationone.cursoangularbackend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
