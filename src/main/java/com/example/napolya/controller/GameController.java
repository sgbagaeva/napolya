package com.example.napolya.controller;

import com.example.napolya.model.Game;
import com.example.napolya.repositories.GameRepository;
import com.example.napolya.repositories.PlayerRepository;
import com.example.napolya.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/edit-game")
    public String manageGame(/*Model model*/) {
        //model.addAttribute("games", /* добавить список игр */);
        return "admin-pages/edit-game";
    }

    @GetMapping("/game")
    public String showGamePage(Model model) {
        model.addAttribute("gameTitle", "Заголовок игры");
        model.addAttribute("gameDescription", "Это описание игры.");
        return "game-template"; // Указываем название вашего шаблона без расширения
    }

    @GetMapping("/new")
    public String createGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "create-game"; // Имя вашего шаблона для создания игры
    }

//    @GetMapping("/new")
//    public String createGameForm(Model model) {
//        model.addAttribute("game", new Game());
//        return "create-game"; // Имя вашего шаблона для создания игры
//    }

    @PostMapping
    public String createGame(@ModelAttribute Game game) {
        gameService.createGame(game);
        return "redirect:/games"; // Перенаправление на список игр
    }

    @GetMapping("/{id}")
    public String getGame(@PathVariable Integer id, Model model) {
        Game game = gameService.getGameById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with ID: " + id));
        model.addAttribute("game", game);
        return "game-details"; // Имя вашего шаблона для отображения деталей игры
    }

    @GetMapping("/edit/{id}")
    public String editGameForm(@PathVariable Integer id, Model model) {
        Game game = gameService.getGameById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with ID: " + id));
        model.addAttribute("game", game);
        return "edit-game"; // Имя вашего шаблона для редактирования игры
    }

    @PostMapping("/edit")
    public String updateGame(@ModelAttribute Game game) {
        gameService.updateGame(game);
        return "redirect:/games"; // Перенаправление на список игр
    }

    @PostMapping("/delete/{id}")
    public String deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
        return "redirect:/games"; // Перенаправление на список игр
    }

}
