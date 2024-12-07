package com.example.napolya.repositories;

import com.example.napolya.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    // Метод для поиска игрока по email
    Optional<Player> findByEmail(String email);
    // Метод для поиска игрока по имени
    Optional<Player> findByName(String name);
}
