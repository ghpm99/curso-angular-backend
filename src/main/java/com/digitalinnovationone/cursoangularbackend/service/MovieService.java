package com.digitalinnovationone.cursoangularbackend.service;

import com.digitalinnovationone.cursoangularbackend.dto.mapper.MovieMapper;
import com.digitalinnovationone.cursoangularbackend.dto.request.MovieDTO;
import com.digitalinnovationone.cursoangularbackend.dto.response.MessageResponseDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Movie;
import com.digitalinnovationone.cursoangularbackend.exception.MovieNotFoundException;
import com.digitalinnovationone.cursoangularbackend.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieService {

    private MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    public MessageResponseDTO create(MovieDTO movieDTO) {
        Movie movieToSave = movieMapper.toModel(movieDTO);
        Movie savedMovie = movieRepository.save(movieToSave);
        return createMessageResponse(savedMovie.getId(), "Created movie with ID :");
    }

    public List<MovieDTO> listAll() {
        List<Movie> allMovie = movieRepository.findAll();

        return allMovie.stream().map(movieMapper::toDTO).collect(Collectors.toList());
    }

    public MovieDTO findById(Integer id) throws MovieNotFoundException {
        Movie movie = verifyIfExists(id);
        return movieMapper.toDTO(movie);
    }

    public void delete(Integer id) throws MovieNotFoundException {
        verifyIfExists(id);
        movieRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Integer id, @Valid MovieDTO movieDTO) throws MovieNotFoundException {
        verifyIfExists(id);

        Movie movieToUpdate = movieMapper.toModel(movieDTO);
        Movie updatedMovie = movieRepository.save(movieToUpdate);
        return createMessageResponse(updatedMovie.getId(), "Update movie with ID:");
    }


    private Movie verifyIfExists(Integer id) throws MovieNotFoundException {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(int id, String message) {
        return MessageResponseDTO.builder().message(message + id).build();
    }
}
