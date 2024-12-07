package com.example.napolya.repositories;

import com.example.napolya.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    Optional<Game> findByName(String name);
}
