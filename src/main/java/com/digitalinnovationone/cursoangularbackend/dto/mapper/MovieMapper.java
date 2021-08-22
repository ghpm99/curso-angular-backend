package com.digitalinnovationone.cursoangularbackend.dto.mapper;

import com.digitalinnovationone.cursoangularbackend.dto.request.MovieDTO;
import com.digitalinnovationone.cursoangularbackend.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "dtLancamento", source = "dtLancamento",dateFormat = "dd/MM/yyyy")
    Movie toModel(MovieDTO movieDTO);

    MovieDTO toDTO(Movie movie);

}
