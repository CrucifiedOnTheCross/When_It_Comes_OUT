package com.sulfur.parsingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AnimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;
    private String date;
    private String duration;

    @ElementCollection
    private List<String> genres;

    @ElementCollection
    private List<String> topics;

    private String rating;
    private String studio;
    private String imgURL;
}
