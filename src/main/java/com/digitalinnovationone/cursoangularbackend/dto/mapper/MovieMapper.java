package com.digitalinnovationone.cursoangularbackend.dto.mapper;

import com.digitalinnovationone.cursoangularbackend.dto.request.MovieDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "dtLancamento", source = "dtLancamento",dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    Movie toModel(MovieDTO movieDTO);

    MovieDTO toDTO(Movie movie);

}
