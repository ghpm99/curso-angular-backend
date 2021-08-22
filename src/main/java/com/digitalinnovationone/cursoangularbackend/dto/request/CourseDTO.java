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
public class CourseDTO {


    private int id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @Size(min = 2, max = 300)
    private String imageUrl;

    @NotEmpty
    private double price;

    @NotEmpty
    private String code;


    private int duration;


    private float rating;

    @NotEmpty
    private String releaseDate;

    @NotEmpty
    private String description;
}
