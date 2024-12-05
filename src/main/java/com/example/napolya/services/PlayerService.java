package com.example.napolya.services;

import com.example.napolya.model.Player;
import com.example.napolya.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Метод для создания нового игрока
    public Player createPlayer(Player player) {
        // Вы можете добавить любую логику валидации, если нужно
        return playerRepository.save(player);
    }

    // Метод для получения всех игроков
    public List<Player> getAllPlayers() {
        return (List<Player>) playerRepository.findAll(); // Преобразование Iterable в List
    }

    // Метод для получения игрока по ID
    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }

    // Метод для обновления игрока
    public Player updatePlayer(Player player) {
        // Проверяем, существует ли игрок
        if (!playerRepository.existsById(player.getId())) {
            throw new RuntimeException("Player not found with ID: " + player.getId());
        }
        return playerRepository.save(player);
    }

    // Метод для удаления игрока
    public void deletePlayer(Integer id) {
        if (!playerRepository.existsById(id)) {
            throw new RuntimeException("Player not found with ID: " + id);
        }
        playerRepository.deleteById(id);
    }

    // Метод для поиска игрока по email
    public Optional<Player> findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    // Метод для поиска игрока по имени
    public Optional<Player> findByName(String name) {
        return playerRepository.findByName(name);
    }
}

