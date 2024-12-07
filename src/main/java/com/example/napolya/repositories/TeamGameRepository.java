package com.example.napolya.repositories;

import com.example.napolya.model.TeamGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamGameRepository extends CrudRepository<TeamGame, Integer> {
    // Дополнительные методы, если нужно
}
