package com.digitalinnovationone.cursoangularbackend.service;

import com.digitalinnovationone.cursoangularbackend.dto.mapper.PostMapper;
import com.digitalinnovationone.cursoangularbackend.dto.request.PostDTO;
import com.digitalinnovationone.cursoangularbackend.dto.response.MessageResponseDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Post;
import com.digitalinnovationone.cursoangularbackend.exception.OrderNotFoundException;
import com.digitalinnovationone.cursoangularbackend.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;

    private final PostMapper postMapper;

    public MessageResponseDTO create(PostDTO postDTO){
        Post postToSave = postMapper.toModel(postDTO);
        Post savedPost = postRepository.save(postToSave);
        return createMessageResponse(savedPost.getId(), "Created post with ID :");
    }

    public List<PostDTO> listAll() {
        List<Post> allPosts = postRepository.findAll();

        return allPosts.stream().map(postMapper::toDTO).collect(Collectors.toList());
    }

    public List<PostDTO> listAll(int page, int limit, String nome, String mensagem, String sort, String order) throws OrderNotFoundException {
        Page<Post> allPosts;

        if (sort != null && order != null) {
            allPosts = postRepository.findAll(PageRequest.of(page, limit, Sort.by(convertOrder(order), sort)));
        } else {
            allPosts = postRepository.findAll(PageRequest.of(page, limit));
        }

        return allPosts.stream().map(postMapper::toDTO).filter((post) -> {
            boolean retorno = true;
            if (nome != null) {
                retorno = retorno && post.getNome().contains(nome);
            }
            if (mensagem != null) {
                retorno = retorno && post.getMensagem().contains(mensagem);
            }
            return retorno;
        }).collect(Collectors.toList());
    }

    public PostDTO findById(Integer id){
        Post post = verifyIfExists(id);
        return postMapper.toDTO(post);
    }

    public void delete(Integer id){
        verifyIfExists(id);
        postRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Integer id, @Valid PostDTO postDTO)  {
        verifyIfExists(id);

        Post postToUpdate = postMapper.toModel(postDTO);
        Post updatedPost = postRepository.save(postToUpdate);
        return createMessageResponse(updatedPost.getId(), "Update post with ID:");
    }

    private Post verifyIfExists(Integer id){
        return postRepository.findById(id).orElseThrow();
    }

    private MessageResponseDTO createMessageResponse(int id, String message) {
        return MessageResponseDTO.builder().message(message + id).build();
    }

    private Sort.Direction convertOrder(String order) throws OrderNotFoundException {
        if(order.toLowerCase().contains("asc")){
            return Sort.Direction.ASC;
        }else if(order.toLowerCase().contains("desc")){
            return Sort.Direction.DESC;
        }
        throw new OrderNotFoundException(order);
    }
}
