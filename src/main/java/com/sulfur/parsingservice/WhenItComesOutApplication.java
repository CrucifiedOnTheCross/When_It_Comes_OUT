package com.sulfur.parsingservice;

import com.sulfur.parsingservice.DTO.AlbumData;
import com.sulfur.parsingservice.DTO.AnimeData;
import com.sulfur.parsingservice.DTO.GameData;
import com.sulfur.parsingservice.DTO.MovieData;
import com.sulfur.parsingservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WhenItComesOutApplication implements CommandLineRunner {

    private final AlbumService albumService;
    private final AnimeService animeService;
    private final MovieService movieService;
    private final GameService gameService;
    private final DataJsonReader dataJsonReader;

    @Autowired
    public WhenItComesOutApplication(AlbumService albumService, AnimeService animeService, MovieService movieService, GameService gameService, DataJsonReader dataJsonReader) {
        this.albumService = albumService;
        this.animeService = animeService;
        this.movieService = movieService;
        this.gameService = gameService;
        this.dataJsonReader = dataJsonReader;
    }

    public static void main(String[] args) {
        SpringApplication.run(WhenItComesOutApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ArrayList<AnimeData> animeData = dataJsonReader.readJsonData("src/main/java/com/sulfur/parsingservice/json/Anime_test.json", AnimeData.class);
//        ArrayList<GameData> gameData = dataJsonReader.readJsonData("src/main/java/com/sulfur/parsingservice/json/Game_test.json", GameData.class);
//        ArrayList<MovieData> movieData = dataJsonReader.readJsonData("src/main/java/com/sulfur/parsingservice/json/Movie_test.json", MovieData.class);
//        ArrayList<AlbumData> albumData = dataJsonReader.readJsonData("src/main/java/com/sulfur/parsingservice/json/Album_test.json", AlbumData.class);

//        for (GameData gameData1 : gameData) {
//            gameService.addGame(gameData1);
//            System.out.println("Game added: " + gameData1);
//        }

//        for (AnimeData animeData1 : animeData) {
//            animeService.addAnime(animeData1);
//            System.out.println("Anime added: " + animeData1);
//        }

//        for (MovieData movieData1 : movieData) {
//            movieService.addMovie(movieData1);
//            System.out.println("Movie added: " + movieData1);
//        }

//        for (AlbumData albumData1 : albumData) {
//            albumService.addAlbum(albumData1);
//            System.out.println("Album added: " + albumData1);
//        }

        System.out.println("Ok");
    }
}
