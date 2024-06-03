package com.sulfur.parsingservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieData implements DataJson {
    private String name;
    private String[] producers;
    private String date;
    private String[] genres;
    private String summary;
    private String imgURL;
}
