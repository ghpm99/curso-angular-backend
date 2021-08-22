package com.digitalinnovationone.cursoangularbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {


    private int id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String titulo;

    private String urlFoto;

    private String dtLancamento;

    private String descricao;

    private float nota;

    private String urlIMDb;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String genero;
}
