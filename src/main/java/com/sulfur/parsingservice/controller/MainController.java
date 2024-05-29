package com.sulfur.parsingservice.controller;

import com.sulfur.parsingservice.DTO.InfoCard;
import com.sulfur.parsingservice.model.GameEntity;
import com.sulfur.parsingservice.service.APIService;
import com.sulfur.parsingservice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private APIService apiService;
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String main(Model model) {
        List<InfoCard> infoCards = apiService.getNewestTitle(10);
        model.addAttribute("infoCards", infoCards);
        return "main";
    }

    @GetMapping("/game/{id}")
    public String gameID(@PathVariable Long id, Model model) {
        GameEntity game = gameService.getGameEntityById(id);
        model.addAttribute("game", game);
        return "game_description";
    }

    @GetMapping("/album/{id}")
    public String albumID(@PathVariable Long id) {
        System.out.println("ID: " + id);
        return "description";
    }

    @GetMapping("/movie/{id}")
    public String movieID(@PathVariable Long id) {
        System.out.println("ID: " + id);
        return "description";
    }

    @GetMapping("/anime/{id}")
    public String animeID(@PathVariable Long id) {
        System.out.println("ID: " + id);
        return "description";
    }

    @GetMapping("/game")
    public String game(Model model) {
        return "game";
    }
}
