package com.sulfur.parsingservice.repository;

import com.sulfur.parsingservice.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    Attribute findByName(String name);
}
