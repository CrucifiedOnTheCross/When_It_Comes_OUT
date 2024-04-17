package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long value_id;

    private long attribute_id;

    @ManyToOne
    @JoinColumn(name = "entity_id", referencedColumnName = "entity_id")
    private EntityObject entityObject;

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "attribute_id")
    private Attribute attribute;


    private String string_value;
    private int int_value;
    private LocalDateTime date_value;
}
