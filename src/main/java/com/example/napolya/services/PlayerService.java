package com.example.napolya.services;

import com.example.napolya.model.Player;
import com.example.napolya.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService extends GenericService<Player, Integer>{
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        super(playerRepository); // Передаем конкретный репозиторий в базовый класс
        this.playerRepository = playerRepository; // Инициализируем поле
    }
    // Метод для поиска игрока по имени
    public Optional<Player> findByName(String name) {
        return playerRepository.findByName(name); // Используем playerRepository
    }
    // Метод для поиска игрока по email
    public Optional<Player> findByEmail(String email) {
        return playerRepository.findByEmail(email); // Используем playerRepository
    }
}

