package com.sulfur.parsingservice.controller;

import com.sulfur.parsingservice.DTO.InfoCard;
import com.sulfur.parsingservice.model.AlbumEntity;
import com.sulfur.parsingservice.model.AnimeEntity;
import com.sulfur.parsingservice.model.GameEntity;
import com.sulfur.parsingservice.model.MovieEntity;
import com.sulfur.parsingservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private APIService apiService;
    @Autowired
    private GameService gameService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private AnimeService animeService;
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String main(Model model) {
        List<InfoCard> infoCards = apiService.getNewestTitle(50);
        model.addAttribute("infoCards", infoCards);
        return "main";
    }

    @GetMapping("/game/{id}")
    public String gameID(@PathVariable Long id, Model model) {
        GameEntity game = gameService.getGameEntityById(id);
        model.addAttribute("game", game);
        return "game_description";
    }

    @GetMapping("/album/{id}")
    public String albumID(@PathVariable Long id, Model model) {
        AlbumEntity album = albumService.getAlbumEntityById(id);
        model.addAttribute("album", album);
        return "album_description";
    }

    @GetMapping("/movie/{id}")
    public String movieID(@PathVariable Long id, Model model) {
        MovieEntity movie = movieService.getMovieEntityById(id);
        model.addAttribute("movie", movie);
        return "movie_description";
    }

    @GetMapping("/anime/{id}")
    public String animeID(@PathVariable Long id, Model model) {
        AnimeEntity anime = animeService.getAnimeEntityById(id);
        model.addAttribute("anime", anime);
        return "anime_description";
    }

    @GetMapping("/game")
    public String game(Model model) {
        List<GameEntity> newestGame = gameService.getNewestGame(50);
        List<InfoCard> infoCards = new ArrayList<>(newestGame.stream()
                .map(game -> new InfoCard(game.getId(), game.getName(), game.getDate().toString(), game.getImgURL(), "game"))
                .toList());

        model.addAttribute("infoCards", infoCards);
        return "main";
    }

    @GetMapping("/album")
    public String album(Model model) {
        List<AlbumEntity> newestGame = albumService.getNewestAlbum(50);
        List<InfoCard> infoCards = new ArrayList<>(newestGame.stream()
                .map(game -> new InfoCard(game.getId(), game.getName(), game.getDate().toString(), game.getImgURL(), "album"))
                .toList());

        model.addAttribute("infoCards", infoCards);
        return "main";
    }

    @GetMapping("/anime")
    public String anime(Model model) {
        List<AnimeEntity> newestGame = animeService.getNewestAnime(50);
        List<InfoCard> infoCards = new ArrayList<>(newestGame.stream()
                .map(game -> new InfoCard(game.getId(), game.getName(), game.getDate().toString(), game.getImgURL(), "anime"))
                .toList());

        model.addAttribute("infoCards", infoCards);
        return "main";
    }

    @GetMapping("/movie")
    public String movie(Model model) {
        List<MovieEntity> newestGame = movieService.getNewestMovie(50);
        List<InfoCard> infoCards = new ArrayList<>(newestGame.stream()
                .map(game -> new InfoCard(game.getId(), game.getName(), game.getDate().toString(), game.getImgURL(), "movie"))
                .toList());

        model.addAttribute("infoCards", infoCards);
        return "main";
    }
}
