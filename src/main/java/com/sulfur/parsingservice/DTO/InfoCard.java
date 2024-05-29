package com.sulfur.parsingservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoCard {
    private Long id;
    private String name;
    private String date;
    private String imgURL;
    private String type;
}
