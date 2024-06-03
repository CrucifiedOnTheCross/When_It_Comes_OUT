package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.DTO.GameData;
import com.sulfur.parsingservice.model.GameEntity;
import com.sulfur.parsingservice.repository.GameRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    private EntityManager entityManager;

    public void addGame(GameData gameData) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setName(gameData.getName());
        gameEntity.setPublishers(gameData.getPublishers());
        gameEntity.setDevelopers(gameData.getDevelopers());
        gameEntity.setFranchises(gameData.getFranchises());
        gameEntity.setSummary(gameData.getSummary());

        String dateString = gameData.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        gameEntity.setDate(date);

        // Устанавливаем платформы, если они не пустые
        if (Objects.nonNull(gameData.getPlatforms())) {
            gameEntity.setPlatforms(Arrays.asList(gameData.getPlatforms()));
        }

        // Устанавливаем жанры, если они не пустые
        if (Objects.nonNull(gameData.getGenres())) {
            gameEntity.setGenres(Arrays.asList(gameData.getGenres()));
        }

        gameEntity.setImgURL(gameData.getImgURL());

        gameRepository.save(gameEntity);
    }

    @Transactional
    public List<GameEntity> getNewestGame(int count) {
        String jpql = "SELECT g FROM GameEntity g ORDER BY g.date DESC";
        TypedQuery<GameEntity> query = entityManager.createQuery(jpql, GameEntity.class);
        query.setMaxResults(count);
        return query.getResultList();
    }

    @Transactional
    public GameEntity getGameEntityById(Long id) {
        return entityManager.find(GameEntity.class, id);
    }
}
