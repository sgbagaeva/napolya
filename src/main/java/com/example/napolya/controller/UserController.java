package com.example.napolya.controller;

import com.example.napolya.model.User;
import com.example.napolya.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/") // Главная страница
    public String index() {
        return "index"; // Возвращает файл index.html
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Создание нового объекта Player
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        // Проверка на существующего пользователя
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("errorMessage", "Ошибка: Пользователь с таким email уже существует.");
            return "registration"; // Возвращение на страницу регистрации с сообщением об ошибке
        }
        // Хэширование пароля (для безопасности)
        // Например: user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Сохранение нового пользователя в БД
        userService.save(user);

        model.addAttribute("userName", user.getName()); // Сохраняем имя в модели

        // Перенаправление в зависимости от роли пользователя
        String redirectUrl = switch (user.getRole()) {
            case "PLAYER" -> "/player"; // Для игроков
            case "PROVIDER" -> "/provider"; // Для провайдеров
            case "ADMIN" -> "/admin"; // Для администраторов
            default -> "/"; // Для других ролей (или при их отсутствии)
        };

        return "redirect:" + redirectUrl; // Перенаправление на соответствующий URL
    }


    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User()); // Создаем новый объект в модели
        return "login"; // Возвращаем страницу входа
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, HttpSession session, Model model) {
        // Проверка на существующего пользователя
        User existingUser = userService.findByName(user.getName()).orElse(null);

// ВАЖНО - добавить обработку при совпадении имён (или имена уникальны?)
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("errorMessage", "Ошибка: Неверное имя пользователя или пароль");
            return "login"; // Возвращаем на страницу логина с сообщением об ошибке
        }

        // Сохраняем id пользователя в сессии
        session.setAttribute("userId", existingUser.getId());

        // Перенаправление в зависимости от роли пользователя
        String redirectUrl = switch (existingUser.getRole()) {
            case "PLAYER" -> "/player"; // Для игроков
            case "PROVIDER" -> "/provider"; // Для провайдеров
            case "ADMIN" -> "/admin"; // Для администраторов
            default -> "/"; // Для других ролей (или при их отсутствии)
        };

        return "redirect:" + redirectUrl; // Перенаправление на соответствующий URL
    }

    /*
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login"; // Перенаправление на страницу логина после выхода
    }
    */
}

