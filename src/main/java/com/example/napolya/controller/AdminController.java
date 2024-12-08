package com.example.napolya.controller;

import com.example.napolya.model.*;
import com.example.napolya.services.*;
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

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerTeamService playerTeamService;

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
            // Сохраняем состояние записи на игру в сессии
            return "games/admin-game"; // Имя шаблона Thymeleaf
        }
        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/gameSignUp")
    public String signUpForGame(@RequestParam("gameId") Integer gameId, HttpSession session) {
        // Не забыть потом закрыть для пользователя запись на эту игру
        // Извлекаем id пользователя из сессии

        Team existingTeam = teamService.findByGameId(gameId).orElse(null);
        Integer teamId;

        if (existingTeam == null) {
           Team newTeam = new Team();
           newTeam.setName("Команда");
           newTeam.setCaptainId(1);
           newTeam.setGameId(gameId);

           teamService.save(newTeam);
           teamId = newTeam.getId();
        } else {
            teamId = existingTeam.getId();
        }

        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            // Сначала находим игрока
            Player player = playerService.findById(userId).orElse(null);

            if (player == null) {
                return "error"; // Или обработка случая, когда игрок не найден
            }

            PlayerTeam playerTeam = new PlayerTeam();
            playerTeam.setPlayerId(userId);
            playerTeam.setTeamId(teamId);
            playerTeamService.save(playerTeam);

            Integer entriesAmount = player.getEntriesAmount();
            player.setEntriesAmount(entriesAmount + 1);
            playerService.save(player);

            // Сохраняем состояние записи на игру в сессии
            session.setAttribute("registeredGameId", gameId);

            return "game-signUp-success"; // Перенаправление на страницу успеха регистрации
        }

        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/unsubscribe")
    public String unsubscribe(@RequestParam("gameId") Integer gameId, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            // Логика отписки от игры

            // Удаляем атрибут из сессии
            session.removeAttribute("registeredGameId");

            return "game-unsubscribe-success"; // Страница успеха отписки
        }

        return "error"; // Шаблон для случая ошибки
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


