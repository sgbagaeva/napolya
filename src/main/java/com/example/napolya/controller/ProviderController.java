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
@RequestMapping("/provider")
public class ProviderController {

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

    @GetMapping()
    public String showProviderPage(HttpSession session, Model model) {
        // Извлекаем id пользователя из сессии
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            User user = userService.findById(userId).orElse(null);
            model.addAttribute("user", user); // Передаем объект провайдера в модель
        }

        return "providerIndex"; // Возвращаем главную страницу провайдера
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> getProviderNames() {
        List<String> providerNames = userService.findAll() // Получаем список пользователей
                .stream()
                .filter(user -> "PROVIDER".equals(user.getRole())) // Фильтрация только для пользователей с ролью PROVIDER
                .map(User::getName) // Извлекаем имена администраторов
                .collect(Collectors.toList()); // Собираем их в список

        return ResponseEntity.ok(providerNames); // Возвращаем список имён с кодом 200
    }

//     @GetMapping("/{id}")
//     public String showAdminPage(@PathVariable)

    @GetMapping("/fields")
    public String listProviderFields(Model model) {
        List<Field> fields = fieldService.findAll();
        model.addAttribute("fields", fields);
        return "user-pages/fields"; // возвращаем имя шаблона
    }

    @GetMapping("/provider-field/{id}")
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
        return "user-pages/manage-players"; // Страница фрагмента для управления игроками
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


