package com.digitalinnovationone.cursoangularbackend.controller;

import com.digitalinnovationone.cursoangularbackend.dto.request.MovieDTO;
import com.digitalinnovationone.cursoangularbackend.dto.response.MessageResponseDTO;
import com.digitalinnovationone.cursoangularbackend.exception.MovieNotFoundException;
import com.digitalinnovationone.cursoangularbackend.exception.OrderNotFoundException;
import com.digitalinnovationone.cursoangularbackend.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {

    private MovieService movieService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createMovie(@RequestBody @Valid MovieDTO movieDTO) {
        return movieService.create(movieDTO);
    }

    @GetMapping
    public List<MovieDTO> listAll(@RequestParam int page,
                                  @RequestParam int limit,
                                  @RequestParam(required = false) String text,
                                  @RequestParam(required = false) String genero,
                                  @RequestParam(required = false) String sort,
                                  @RequestParam(required = false) String order) throws OrderNotFoundException {

        return movieService.listAll(page, limit, text, genero, sort, order);
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable Integer id) throws MovieNotFoundException {
        return movieService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) throws MovieNotFoundException {
        movieService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Integer id, @RequestBody @Valid MovieDTO movieDTO) throws MovieNotFoundException {
        return movieService.updateById(id, movieDTO);
    }
}
