package com.example.napolya.controller;

import com.example.napolya.model.*;
import com.example.napolya.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private UserService userService;
    @Autowired
    private GameService gameService;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerTeamService playerTeamService;

    @GetMapping("/list")
    public ResponseEntity<List<String>> getPlayerNames() {
        List<String> playerNames = userService.findAll() // Получаем список пользователей
                .stream()
                .filter(user -> "PLAYER".equals(user.getRole())) // Фильтрация только для пользователей с ролью PLAYER
                .map(User::getName) // Извлекаем имена администраторов
                .collect(Collectors.toList()); // Собираем их в список

        return ResponseEntity.ok(playerNames); // Возвращаем список имён с кодом 200
    }

    @GetMapping()
    public String showPlayerPage(HttpSession session, Model model) {
        // Извлекаем id пользователя из сессии
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            User user = userService.findById(userId).orElse(null);
            model.addAttribute("user", user); // Передаем объект в модель
        }

        return "playerIndex"; // Возвращаем главную страницу игрока
    }

}



