package data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicData {
    private String name;
    private String author;
    private String date;
    private String imgURL;
    private String[] tags;
    private String[] trackList;
}
