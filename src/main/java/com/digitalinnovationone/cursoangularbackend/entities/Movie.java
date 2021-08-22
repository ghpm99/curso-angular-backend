package com.digitalinnovationone.cursoangularbackend.entities;

import lombok.Data;

import java.sql.Date;

@Data
public class Movie {

    private int id;

    private String titulo;

    private String urlFoto;

    private Date dtLancamento;

    private String descricao;

    private float nota;

    private String urlIMDb;

    private String genero;

}
