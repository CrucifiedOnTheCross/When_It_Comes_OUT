package com.sulfur.parsingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sulfur.parsingservice.data.DataJson;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class DataJsonReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T extends DataJson> ArrayList<T> readJsonData(String filePath, Class<T> clazz) throws IOException {
        File file = new File(filePath);
        if (!file.exists())
            throw new IllegalArgumentException("File does not exist: " + filePath);

        return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz));
    }
}
