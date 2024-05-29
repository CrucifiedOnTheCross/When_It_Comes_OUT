package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.DTO.InfoCard;
import com.sulfur.parsingservice.model.AlbumEntity;
import com.sulfur.parsingservice.model.AnimeEntity;
import com.sulfur.parsingservice.model.GameEntity;
import com.sulfur.parsingservice.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class APIService {
    AlbumService albumService;
    AnimeService animeService;
    GameService gameService;
    MovieService movieService;

    @Autowired
    public APIService(AlbumService albumService, AnimeService animeService, GameService gameService, MovieService movieService) {
        this.albumService = albumService;
        this.animeService = animeService;
        this.gameService = gameService;
        this.movieService = movieService;
    }

    public List<InfoCard> getNewestTitle(int maxSize) {
        List<InfoCard> newestTitles = new ArrayList<>();

        // Get newest anime
        List<AnimeEntity> newestAnime = animeService.getNewestAnime(maxSize);
        newestTitles.addAll(newestAnime.stream()
                .map(anime -> new InfoCard(anime.getId(), anime.getName(), anime.getDate(), anime.getImgURL(), "anime"))
                .collect(Collectors.toList()));

        // Get newest album
        List<AlbumEntity> newestAlbum = albumService.getNewestAlbum(maxSize);
        newestTitles.addAll(newestAlbum.stream()
                .map(album -> new InfoCard(album.getId(), album.getName(), album.getDate(), album.getImgURL(), "album"))
                .collect(Collectors.toList()));

        // Get newest game
        List<GameEntity> newestGame = gameService.getNewestGame(maxSize);
        newestTitles.addAll(newestGame.stream()
                .map(game -> new InfoCard(game.getId(), game.getName(), game.getDate(), game.getImgURL(), "game"))
                .collect(Collectors.toList()));

        // Get newest movie
        List<MovieEntity> newestMovie = movieService.getNewestMovie(maxSize);
        newestTitles.addAll(newestMovie.stream()
                .map(movie -> new InfoCard(movie.getId(), movie.getName(), movie.getDate(), movie.getImgURL(), "movie"))
                .collect(Collectors.toList()));


        // Sort by date and take top 10
        return newestTitles.stream()
                .sorted(Comparator.comparing(InfoCard::getDate).reversed())
                .limit(maxSize)
                .collect(Collectors.toList());
    }
}
