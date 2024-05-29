package com.sulfur.parsingservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumData implements DataJson {
    private String name;
    private String author;
    private String date;
    private String imgURL;
    private String[] tags;
    private String[] trackList;
}
