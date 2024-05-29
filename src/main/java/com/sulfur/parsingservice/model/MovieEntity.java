package com.sulfur.parsingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<String> producers;

    private String date;

    @ElementCollection
    private List<String> genres;

    @Lob
    private String summary;

    private String imgURL;
}
