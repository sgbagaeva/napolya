package com.example.napolya.repositories;

import com.example.napolya.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
    // Метод для поиска команды по названию
    Optional<Team> findByName(String name);
    // Метод для поиска команды по ID игры (пока что считаем, что 1 команда на 1 игру)
    Optional<Team> findByGameId(Integer gameId);
}
