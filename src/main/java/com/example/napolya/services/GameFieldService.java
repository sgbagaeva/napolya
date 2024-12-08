package com.example.napolya.services;

import com.example.napolya.model.Field;
import com.example.napolya.model.GameField;
import com.example.napolya.repositories.FieldRepository;
import com.example.napolya.repositories.GameFieldRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameFieldService extends GenericService<GameField, Integer> {
    private final GameFieldRepository gameFieldRepository;

    public GameFieldService(GameFieldRepository gameFieldRepository) {
        super(gameFieldRepository);
        this.gameFieldRepository = gameFieldRepository;
    }
}

