package com.example.napolya.repositories;

import com.example.napolya.model.Game;
import com.example.napolya.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    // Метод для поиска игры по названию
    Optional<Game> findByName(String name);
}
