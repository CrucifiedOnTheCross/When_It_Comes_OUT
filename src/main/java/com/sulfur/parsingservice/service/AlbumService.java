package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.DTO.AlbumData;
import com.sulfur.parsingservice.model.AlbumEntity;
import com.sulfur.parsingservice.repository.AlbumRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void addAlbum(AlbumData albumData) {
        AlbumEntity albumEntity = new AlbumEntity();
        albumEntity.setName(albumData.getName());
        albumEntity.setAuthor(albumData.getAuthor());
        albumEntity.setDate(albumData.getDate());
        albumEntity.setImgURL(albumData.getImgURL());

        // Устанавливаем теги, если они не пустые
        if (Objects.nonNull(albumData.getTags())) {
            albumEntity.setTags(Arrays.asList(albumData.getTags()));
        }

        // Устанавливаем список треков, если они не пустые
        if (Objects.nonNull(albumData.getTrackList())) {
            albumEntity.setTrackList(Arrays.asList(albumData.getTrackList()));
        }

        albumRepository.save(albumEntity);
    }

    public List<AlbumEntity> getNewestAlbum(int count) {
        String jpql = "SELECT a FROM AlbumEntity a ORDER BY a.date DESC";
        TypedQuery<AlbumEntity> query = entityManager.createQuery(jpql, AlbumEntity.class);
        query.setMaxResults(count);
        return query.getResultList();
    }
}
