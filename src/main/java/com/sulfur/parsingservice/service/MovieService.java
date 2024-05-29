package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.DTO.MovieData;
import com.sulfur.parsingservice.model.MovieEntity;
import com.sulfur.parsingservice.repository.MovieRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public void addMovie(MovieData movieData) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movieData.getName());

        // Устанавливаем производителей, если они не пустые
        if (Objects.nonNull(movieData.getProducers())) {
            movieEntity.setProducers(Arrays.asList(movieData.getProducers()));
        }

        movieEntity.setDate(movieData.getDate());

        // Устанавливаем жанры, если они не пустые
        if (Objects.nonNull(movieData.getGenres())) {
            movieEntity.setGenres(Arrays.asList(movieData.getGenres()));
        }

        movieEntity.setSummary(movieData.getSummary());
        movieEntity.setImgURL(movieData.getImgURL());

        movieRepository.save(movieEntity);
    }

    @Transactional
    public List<MovieEntity> getNewestMovie(int count) {
        String jpql = "SELECT m FROM MovieEntity m ORDER BY m.date DESC";
        TypedQuery<MovieEntity> query = entityManager.createQuery(jpql, MovieEntity.class);
        query.setMaxResults(count);
        return query.getResultList();
    }
}
