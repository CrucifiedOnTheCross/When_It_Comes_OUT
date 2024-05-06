package com.sulfur.parsingservice.service;

import com.sulfur.parsingservice.data.DataJson;
import com.sulfur.parsingservice.model.Attribute;
import com.sulfur.parsingservice.model.Entity;
import com.sulfur.parsingservice.model.Value;
import com.sulfur.parsingservice.repository.AttributeRepository;
import com.sulfur.parsingservice.repository.EntityRepository;
import com.sulfur.parsingservice.repository.ValueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;

@Service
public class DataJsonService {

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private ValueRepository valueRepository;

    @Transactional
    public <T extends DataJson> void saveDataList(ArrayList<T> dataList) throws IllegalAccessException {
        for (DataJson data : dataList) {
            Entity entity = new Entity();
            entity.setName(data.getEntityName());
            entity = entityRepository.save(entity);

            Class<?> clazz = data.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String attributeName = field.getName();
                String attributeType = field.getType().getSimpleName();

                Object fieldValue = field.get(data);
                if (fieldValue != null) {
                    if (fieldValue.getClass().isArray()) {
                        Object[] array = (Object[]) fieldValue;
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Object element : array) {
                            if (element != null) {
                                stringBuilder.append(element.toString()).append(" "); // Append each string with a space separator
                            }
                        }
                        String value = stringBuilder.toString().trim(); // Trim the string to remove trailing space
                        saveOrUpdateValue(entity, attributeName, attributeType, value);
                    } else {
                        String value = fieldValue.toString();
                        saveOrUpdateValue(entity, attributeName, attributeType, value);
                    }
                }
            }
        }

        System.out.println("Ok, sava data to database!");
    }

    private void saveOrUpdateValue(Entity entity, String attributeName, String attributeType, String value) {
        Attribute attribute = attributeRepository.findByName(attributeName);
        if (attribute == null) {
            attribute = new Attribute();
            attribute.setName(attributeName);
            attribute.setType(attributeType);
            attribute = attributeRepository.save(attribute);
        }

        Value existingValue = valueRepository.findByEntityAndAttribute(entity, attribute);
        if (existingValue != null) {
            existingValue.setValue(value);
            valueRepository.save(existingValue);
        } else {
            Value newValue = new Value();
            newValue.setEntity(entity);
            newValue.setAttribute(attribute);
            newValue.setValue(value);
            valueRepository.save(newValue);
        }
    }
}
