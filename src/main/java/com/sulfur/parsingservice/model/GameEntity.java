package com.sulfur.parsingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String publishers;
    private String developers;
    private String franchises;

    @Lob
    private String summary;
    private LocalDate date;

    @ElementCollection
    private List<String> platforms;

    @ElementCollection
    private List<String> genres;

    private String imgURL;
}
