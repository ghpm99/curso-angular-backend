package com.digitalinnovationone.cursoangularbackend.repositories;

import com.digitalinnovationone.cursoangularbackend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
