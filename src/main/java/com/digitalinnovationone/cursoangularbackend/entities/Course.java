package com.digitalinnovationone.cursoangularbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private float rating;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String description;


}
