package com.example.napolya.repositories;

import com.example.napolya.model.GameField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameFieldRepository extends CrudRepository<GameField, Integer> {
    // Дополнительные методы, если нужно
}
