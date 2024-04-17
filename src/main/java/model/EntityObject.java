package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@jakarta.persistence.Entity
@Getter
@Setter
public class EntityObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entity_id;

    private String entity_name;

    @OneToMany(mappedBy = "entityObject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EntityObject> values;
}
