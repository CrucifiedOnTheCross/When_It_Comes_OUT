package com.sulfur.parsingservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private String date;
    private String imgURL;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private List<String> trackList;
}
