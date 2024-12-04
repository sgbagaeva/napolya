package com.example.napolya.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PagesController {
    @GetMapping("/games") // Страница с играми
    public String games() {
        return "games"; // Возвращает файл games.html
    }

    @GetMapping("/fields") // Главная страница
    public String fields() {
        return "fields"; // Возвращает файл fields.html
    }
}
