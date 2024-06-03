package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.DTO.AlbumData;
import com.sulfur.parsingservice.model.AlbumEntity;
import com.sulfur.parsingservice.repository.AlbumRepository;
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

        String dateString = albumData.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        albumEntity.setDate(date);

        albumEntity.setImgURL(albumData.getImgURL());

        if (Objects.nonNull(albumData.getTags())) {
            albumEntity.setTags(Arrays.asList(albumData.getTags()));
        }

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

    @Transactional
    public AlbumEntity getAlbumEntityById(Long id) {
        return entityManager.find(AlbumEntity.class, id);
    }
}
