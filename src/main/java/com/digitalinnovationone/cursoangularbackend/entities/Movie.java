package com.digitalinnovationone.cursoangularbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    private String urlFoto;

    private LocalDate dtLancamento;

    private String descricao;

    private float nota;

    private String urlIMDb;

    @Column(nullable = false)
    private String genero;

}
