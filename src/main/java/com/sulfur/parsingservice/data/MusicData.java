package com.sulfur.parsingservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicData implements DataJson {
    private String name;
    private String author;
    private String date;
    private String imgURL;
    private String[] tags;
    private String[] trackList;

    @Override
    public String getEntityName() {
        return "music";
    }
}
