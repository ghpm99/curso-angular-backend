package com.digitalinnovationone.cursoangularbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String mensagem;
}
