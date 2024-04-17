package data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GameData {
    private String name;
    private LocalDate data;
}
