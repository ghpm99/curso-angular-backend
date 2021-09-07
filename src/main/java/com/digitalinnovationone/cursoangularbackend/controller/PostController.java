package com.digitalinnovationone.cursoangularbackend.controller;

import com.digitalinnovationone.cursoangularbackend.dto.request.PostDTO;
import com.digitalinnovationone.cursoangularbackend.dto.response.MessageResponseDTO;
import com.digitalinnovationone.cursoangularbackend.exception.OrderNotFoundException;
import com.digitalinnovationone.cursoangularbackend.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPost(@RequestBody @Valid PostDTO postDTO) {
        return postService.create(postDTO);
    }

    @GetMapping
    public List<PostDTO> listAll(@RequestParam int page,
                                 @RequestParam int limit,
                                 @RequestParam(required = false) String nome,
                                 @RequestParam(required = false) String mensagem,
                                 @RequestParam(required = false) String sort,
                                 @RequestParam(required = false) String order) throws OrderNotFoundException {

        return postService.listAll(page, limit, nome, mensagem, sort, order);
    }

    @GetMapping("/{id}")
    public PostDTO findById(@PathVariable Integer id) {
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id) {
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Integer id, @RequestBody @Valid PostDTO postDTO) {
        return postService.updateById(id, postDTO);
    }

}
