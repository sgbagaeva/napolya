package com.example.napolya.controller;

import com.example.napolya.dto.PlayerRequest;
import com.example.napolya.dto.PlayerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class PlayerDataController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/getPlayerData")
    public ResponseEntity<PlayerResponse> getPlayerData(@RequestBody PlayerRequest playerRequest) {
        String url = "http://fpolyana.spb.ru/enroll/getPlayerData";
        try {
            // Отправка POST-запроса к внешнему API
            PlayerResponse response = restTemplate.postForObject(url, playerRequest, PlayerResponse.class);
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(404).body(null); // Игрок не найден
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Ошибка сервера
        }
    }
}
