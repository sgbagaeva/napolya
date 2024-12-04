package com.example.napolya.controller;


import com.example.napolya.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showAdminPage(Model model, @ModelAttribute("adminName") String adminName) {
        model.addAttribute("adminName", adminName); // Передаем имя администратора в модель
        return "admin"; // Возвращаем страницу администратора
    }

    @GetMapping("/games")
    public String manageGames() {
        return "games"; // Шаблон для управления играми
    }

    @GetMapping("/fields")
    public String manageFields() {
        return "fields"; // Шаблон для управления полями
    }

    @GetMapping("/manage-players")
    public String managePlayers() {
        return "manage-players"; // Шаблон для управления игроками
    }

    @GetMapping("/my-games")
    public String myGames() {
        return "my-games"; // Шаблон для "Мои игры"
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts"; // Шаблон для контактов
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile"; // Шаблон для профиля
    }
}

