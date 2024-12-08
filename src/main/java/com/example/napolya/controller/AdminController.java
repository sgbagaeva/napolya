package com.example.napolya.controller;

import com.example.napolya.model.Field;
import com.example.napolya.model.Game;
import com.example.napolya.model.Player;
import com.example.napolya.services.FieldService;
import com.example.napolya.services.GameService;
import com.example.napolya.services.PlayerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private GameService gameService;

    @Autowired
    private FieldService fieldService;

    @GetMapping()
    public String showAdminPage(HttpSession session, Model model) {
        // Извлекаем id пользователя из сессии
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            // Здесь вы можете использовать userId для получения дополнительной информации о пользователе (например, через PlayerService)
            Player player = playerService.findById(userId).orElse(null);
            model.addAttribute("player", player); // Передаем объект игрока в модель
        }

        return "admin"; // Возвращаем страницу администратора
    }

//     @GetMapping("/{id}")
//     public String showAdminPage(@PathVariable)

    @GetMapping("/games")
    public String listGames(Model model) {
        List<Game> games = gameService.findAll();
        model.addAttribute("games", games); // используйте "games"
        return "admin-pages/games"; // возвращаем имя шаблона
    }

    @GetMapping("/games/{id}")
    public String getGameDetails(@PathVariable("id") Integer gameId, Model model) {
        Game game = gameService.findById(gameId).orElse(null);
        if (game != null) {
            model.addAttribute("game", game);
            return "games/admin-game"; // Имя шаблона Thymeleaf
        }
        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/gameSignUp")
    public String signUpForGame(@RequestParam("gameId") Integer gameId, HttpSession session) {
        //
        // Извлекаем id пользователя из сессии
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            Player player = playerService.findById(userId).orElse(null);

            return "game-signUp-success"; // Перенаправление на страницу успеха регистрации
        }

        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/fields")
    public String listFields(Model model) {
        List<Field> fields = fieldService.findAll();
        model.addAttribute("fields", fields);
        return "admin-pages/fields"; // возвращаем имя шаблона
    }

    @GetMapping("/admin-field/{id}")
    public String getFieldDetails(@PathVariable("id") Integer fieldId, Model model) {
        Field field = fieldService.findById(fieldId).orElse(null);
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


