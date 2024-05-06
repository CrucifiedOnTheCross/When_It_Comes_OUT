package com.sulfur.parsingservice.repository;

import com.sulfur.parsingservice.model.Attribute;
import com.sulfur.parsingservice.model.Entity;
import com.sulfur.parsingservice.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long> {
    Value findByEntityAndAttribute(Entity entity, Attribute attribute);
}
