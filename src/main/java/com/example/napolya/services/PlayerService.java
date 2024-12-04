package com.example.napolya.services;

import com.example.napolya.model.Player;
import com.example.napolya.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player register(Player player) {
        // Реализуйте сохранение пользователя (например, с шифрованием пароля)
        return playerRepository.save(player);
    }
}
