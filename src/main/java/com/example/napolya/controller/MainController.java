package com.example.napolya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    @GetMapping("/") // Главная страница
    public String index() {
        return "index"; // Возвращает файл index.html
    }

}
