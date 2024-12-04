package com.example.napolya.controller;

import com.example.napolya.model.Player;
import com.example.napolya.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/") // Главная страница
    public String index() {
        return "index"; // Возвращает файл index.html
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("player", new Player()); // Создание нового объекта Player
        return "registration";
    }

    @PostMapping("/registration")
    public String registerPlayer(@ModelAttribute Player player, Model model) {
        // Проверка на существующего пользователя
        if (playerRepository.findByEmail(player.getEmail()).isPresent()) {
            model.addAttribute("errorMessage", "Ошибка: Пользователь с таким email уже существует.");
            return "registration"; // Возвращение на страницу регистрации с сообщением об ошибке
        }

        // Хэширование пароля (для безопасности)

        // Сохранение нового игрока в БД
        playerRepository.save(player);

        model.addAttribute("adminName", player.getName()); // Сохраняем имя администратора в модели
        return "redirect:/admin"; // Перенаправление на страницу администратора после успешной регистрации
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("player", new Player()); // Создаем новый объект Player в модели
        return "login"; // Возвращаем страницу входа
    }


    @PostMapping("/login")
    public String loginPlayer(@ModelAttribute Player player, Model model) {
        // Проверка на существующего пользователя
        Player existingPlayer = playerRepository.findByName(player.getName()).orElse(null);
// ВАЖНО - добавить обработку при совпадении имён
        if (existingPlayer == null || !existingPlayer.getPassword().equals(player.getPassword())) {
            model.addAttribute("errorMessage", "Ошибка: Неверное имя пользователя или пароль");
            return "login"; // Возвращаем на страницу логина с сообщением об ошибке
        }

        // Если логин успешен, перенаправляем на страницу администратора
        model.addAttribute("adminName", existingPlayer.getName()); // Сохраняем имя администратора для отображения

        return "redirect:/admin"; // Перенаправление на главную страницу пользователя после успешной регистрации
    }

    /*
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login"; // Перенаправление на страницу логина после выхода
    }
    */
}

