package com.sulfur.parsingservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GameData implements DataJson {
    private String name;
    private LocalDate data;

    @Override
    public String getEntityName() {
        return "game";
    }
}
