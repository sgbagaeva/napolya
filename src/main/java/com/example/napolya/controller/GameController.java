package com.example.napolya.controller;

import com.example.napolya.model.*;
import com.example.napolya.services.GameService;
import com.example.napolya.services.PlayerTeamService;
import com.example.napolya.services.TeamService;
import com.example.napolya.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerTeamService playerTeamService;

    @Autowired
    private TeamsInfo teamsInfo;

    @GetMapping("/player/games")
    public String listPlayerGames(Model model) {
        List<Game> games = gameService.findAll();
        model.addAttribute("games", games); // используйте "games"
        return "user-pages/available-games"; // возвращаем имя шаблона
    }

    @GetMapping("/provider/games")
    public String listProviderGames(Model model) {
        List<Game> games = gameService.findAll();
        model.addAttribute("games", games); // используйте "games"
        return "user-pages/provider-games"; // возвращаем имя шаблона
    }

    @GetMapping("/provider/games/{id}")
    public String getProviderGameDetails(@PathVariable("id") Integer gameId, Model model) {
        Game game = gameService.findById(gameId).orElse(null);
        if (game != null) {
            model.addAttribute("game", game);
            model.addAttribute("teamsInfo", teamsInfo);
            // Сохраняем состояние записи на игру в сессии
            return "games/manage-game"; // Имя шаблона Thymeleaf
        }
        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/player/games/{id}")
    public String getPlayerGameDetails(@PathVariable("id") Integer gameId, Model model) {
        Game game = gameService.findById(gameId).orElse(null);
        if (game != null) {
            model.addAttribute("game", game);
            // Сохраняем состояние записи на игру в сессии
            return "games/game"; // Имя шаблона Thymeleaf
        }
        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/player/gameSignUp/{id}")
    public String signUpForGame(@PathVariable("id") Integer gameId, HttpSession session) {
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
            User user = userService.findById(userId).orElse(null);

            if (user == null) {
                return "error"; // Или обработка случая, когда игрок не найден
            }

            PlayerTeam playerTeam = new PlayerTeam();
            playerTeam.setPlayerId(userId);
            playerTeam.setTeamId(teamId);
            playerTeamService.save(playerTeam);

            Integer entriesAmount = user.getEntriesAmount();
            user.setEntriesAmount(entriesAmount + 1);
            userService.save(user);

            // Сохраняем состояние записи на игру в сессии
            session.setAttribute("registeredGameId", gameId);

            return "player-game-signUp-success"; // Перенаправление на страницу успеха регистрации
        }

        return "error"; // Шаблон для случая, если игра не найдена
    }

    @GetMapping("/provider/unsubscribe")
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
}
