package com.sulfur.parsingservice;

import com.sulfur.parsingservice.data.DataJson;
import com.sulfur.parsingservice.data.MusicData;
import com.sulfur.parsingservice.repository.ValueRepository;
import com.sulfur.parsingservice.service.DataJsonReader;
import com.sulfur.parsingservice.service.DataJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class WhenItComesOutApplication implements CommandLineRunner {
    @Autowired
    private DataJsonService dataJsonService;

    @Autowired
    private DataJsonReader jsonDataService;

    @Autowired
    private ValueRepository valueRepository;

    public static void main(String[] args) {
        SpringApplication.run(WhenItComesOutApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ArrayList<MusicData> dataJsons = jsonDataService.readJsonData("C:\\Users\\user\\IdeaProjects\\When It Comes OUT\\src\\main\\java\\com\\sulfur\\parsingservice\\parsertest\\js1.json", MusicData.class);
        dataJsonService.saveDataList(dataJsons);
    }
}
