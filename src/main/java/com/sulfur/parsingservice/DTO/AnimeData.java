package com.sulfur.parsingservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeData implements DataJson {
    private String name;
    private String type;
    private String date;
    private String duration;
    private String[] genres;
    private String[] topics;
    private String rating;
    private String studio;
    private String imgURL;
}