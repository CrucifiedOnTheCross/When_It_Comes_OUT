package com.sulfur.parsingservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameData implements DataJson {
    private String name;
    private String publishers;
    private String developers;
    private String franchises;
    private String summary;
    private String date;
    private String[] platforms;
    private String[] genres;
    private String imgURL;
}
