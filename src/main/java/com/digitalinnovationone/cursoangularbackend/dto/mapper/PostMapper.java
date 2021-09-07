package com.digitalinnovationone.cursoangularbackend.dto.mapper;

import com.digitalinnovationone.cursoangularbackend.dto.request.PostDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toModel(PostDTO post);

    PostDTO toDTO(Post model);
}
