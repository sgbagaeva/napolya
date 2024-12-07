package com.example.napolya.services;

import com.example.napolya.model.Game;
import com.example.napolya.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService extends GenericService<Game, Integer> {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        super(gameRepository);
        this.gameRepository = gameRepository;
    }
    // Метод для поиска игры по названию
    public Optional<Game> findByName(String name) {
        return gameRepository.findByName(name);
    }
}

