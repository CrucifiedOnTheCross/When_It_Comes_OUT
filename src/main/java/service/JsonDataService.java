package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.MusicData;
import model.Attribute;
import model.EntityObject;
import model.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AttributeRepository;
import repository.EntityObjectRepository;
import repository.ValueRepository;

import java.io.IOException;
import java.util.List;

@Service
public class JsonDataService {
    private final EntityObjectRepository entityObjectRepository;
    private final AttributeRepository attributeRepository;
    private final ValueRepository valueRepository;


    @Autowired
    public JsonDataService(EntityObjectRepository entityObjectRepository, AttributeRepository attributeRepository, ValueRepository valueRepository) {
        this.entityObjectRepository = entityObjectRepository;
        this.attributeRepository = attributeRepository;
        this.valueRepository = valueRepository;
    }

    public <T> void saveJsonData(String filePath, Class<T> name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        MusicData musicData = mapper.readValue(filePath, MusicData.class);

        EntityObject entityObject = new EntityObject();
        entityObject.setEntity_name(musicData.getName());

        entityObjectRepository.save(entityObject);

        saveAttributesAndValues(entityObject, musicData.getTags(), "tags");
        saveAttributesAndValues(entityObject, musicData.getTrackList(), "trackList");
    }

    private void saveAttributesAndValues(EntityObject entityObject, List<String> values, String attributeName) {
        Attribute attribute = new Attribute();
        attribute.setEntity_id(entityObject.getEntity_id());
        attribute.setAttribute_name(attributeName);

        attributeRepository.save(attribute);

        for (String valueStr : values) {
            Value value = new Value();
            value.setEntityObject(entityObject);
            value.setAttribute(attribute);
            value.setString_value();
            value.setDate_value();

            System.out.println(valueStr);
        }
    }
}
