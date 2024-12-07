package com.example.napolya.services;

import com.example.napolya.model.Game;
import com.example.napolya.model.Game;
import com.example.napolya.model.Player;
import com.example.napolya.repositories.GameRepository;
import com.example.napolya.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Метод для сохранения новой игры
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    // Метод для получения всех игр
    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }

    // Метод для получения игры по ID
    public Optional<Game> getGameById(Integer id) {
        return gameRepository.findById(id);
    }

    // Метод для обновления игры
    public Game updateGame(Game game) {
        // Проверяем, существует ли игра
        if (!gameRepository.existsById(game.getId())) {
            throw new RuntimeException("Game not found with ID: " + game.getId());
        }
        return gameRepository.save(game);
    }

    // Метод для удаления игры
    public void deleteGame(Integer id) {
        if (!gameRepository.existsById(id)) {
            throw new RuntimeException("Game not found with ID: " + id);
        }
        gameRepository.deleteById(id);
    }

    // Метод для поиска игрока по названию
    public Optional<Game> findByName(String name) {
        return gameRepository.findByName(name);
    }
}

