package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.DTO.AnimeData;
import com.sulfur.parsingservice.model.AnimeEntity;
import com.sulfur.parsingservice.repository.AnimeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Autowired
    private EntityManager entityManager;

    public void addAnime(AnimeData animeData) {
        AnimeEntity animeEntity = new AnimeEntity();
        animeEntity.setName(animeData.getName());
        animeEntity.setType(animeData.getType());
        animeEntity.setDate(animeData.getDate());
        animeEntity.setDuration(animeData.getDuration());
        animeEntity.setRating(animeData.getRating());
        animeEntity.setStudio(animeData.getStudio());
        animeEntity.setImgURL(animeData.getImgURL());

        // Устанавливаем жанры, если они не пустые
        if (Objects.nonNull(animeData.getGenres())) {
            animeEntity.setGenres(Arrays.asList(animeData.getGenres()));
        }

        // Устанавливаем топики, если они не пустые
        if (Objects.nonNull(animeData.getTopics())) {
            animeEntity.setTopics(Arrays.asList(animeData.getTopics()));
        }

        animeRepository.save(animeEntity);
    }

    public List<AnimeEntity> getNewestAnime(int count) {
        String jpql = "SELECT a FROM AnimeEntity a ORDER BY a.date DESC";
        TypedQuery<AnimeEntity> query = entityManager.createQuery(jpql, AnimeEntity.class);
        query.setMaxResults(count);
        return query.getResultList();
    }
}
