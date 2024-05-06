package com.sulfur.parsingservice.repository;

import com.sulfur.parsingservice.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<Entity, Long> {
    Entity findByName(String name);
}
