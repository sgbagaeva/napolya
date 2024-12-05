package com.example.napolya.services;

import com.example.napolya.model.Game;
import com.example.napolya.repositories.GameRepository;
import com.example.napolya.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Метод для создания новой игры
    public void createGame(Game game) {
        // Вы можете добавить любую логику валидации, если нужно
        gameRepository.save(game);
    }

    // Метод для получения всех игр
    public List<Game> getAllGames() {
        return (List<Game>) gameRepository.findAll(); // Преобразование Iterable в List
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
}