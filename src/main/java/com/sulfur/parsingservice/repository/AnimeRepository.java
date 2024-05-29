package com.sulfur.parsingservice.repository;

import com.sulfur.parsingservice.model.AnimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<AnimeEntity, Long> {
}
