package com.example.napolya.repositories;

import com.example.napolya.model.QueueGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueGameRepository extends CrudRepository<QueueGame, Integer> {
    // Дополнительные методы, если нужно
}
