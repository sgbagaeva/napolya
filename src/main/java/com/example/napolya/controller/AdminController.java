package com.example.napolya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String showAdminPage(Model model, @ModelAttribute("adminName") String adminName) {
        model.addAttribute("adminName", adminName); // Передаем имя администратора в модель
        return "admin"; // Возвращаем страницу администратора
    }

    @GetMapping("/games")
    public String manageGames(/*Model model*/) {
        //model.addAttribute("games", /* добавить список игр */);
        return "admin-pages/games"; // Обратите внимание на использование фрагмента
    }

    @GetMapping("/fields")
    public String manageFields() {
        return "admin-pages/fields"; // Страница фрагмента для управления полями
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


