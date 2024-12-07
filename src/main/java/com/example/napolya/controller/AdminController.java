package com.example.napolya.controller;

import com.example.napolya.model.Field;
import com.example.napolya.model.Game;
import com.example.napolya.services.FieldService;
import com.example.napolya.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GameService gameService;

    @Autowired
    private FieldService fieldService;

    @GetMapping()
    public String showAdminPage(Model model, @ModelAttribute("adminName") String adminName) {
        model.addAttribute("adminName", adminName); // Передаем имя администратора в модель
        return "admin"; // Возвращаем страницу администратора
    }

//     @GetMapping("/{id}")
//     public String showAdminPage(@PathVariable)

    @GetMapping("/games")
    public String listGames(Model model) {
        List<Game> games = gameService.getAllGames();
        model.addAttribute("games", games); // используйте "games"
        return "admin-pages/games"; // возвращаем имя шаблона
    }

    @GetMapping("/games/{id}")
    public String getGameDetails(@PathVariable("id") Integer gameId, Model model) {
        Game game = gameService.getGameById(gameId).orElse(null);
        if (game != null) {
            model.addAttribute("game", game);
            return "games/admin-game"; // Имя шаблона Thymeleaf
        }
        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/fields")
    public String listFields(Model model) {
        List<Field> fields = fieldService.getAllFields();
        model.addAttribute("fields", fields);
        return "admin-pages/fields"; // возвращаем имя шаблона
    }

    @GetMapping("/admin-field/{id}")
    public String getFieldDetails(@PathVariable("id") Integer fieldId, Model model) {
        Field field = fieldService.getFieldById(fieldId).orElse(null);
        if (field != null) {
            model.addAttribute("field", field);
            return "games/admin-field"; // Имя шаблона Thymeleaf
        }
        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/manage-players")
    public String managePlayers() {
        return "admin-pages/manage-players"; // Страница фрагмента для управления игроками
    }

    @GetMapping("/my-games")
    public String myGames() {
        return "admin-pages/my-games"; // Страница фрагмента для "Мои игры"
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "admin-pages/contacts"; // Страница фрагмента для контактов
    }

    @GetMapping("/profile")
    public String profile() {
        return "admin-pages/profile"; // Страница фрагмента для профиля
    }
}


