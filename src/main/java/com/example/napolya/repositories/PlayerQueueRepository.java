package com.example.napolya.repositories;

import com.example.napolya.model.PlayerQueue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerQueueRepository extends CrudRepository<PlayerQueue, Integer> {
    // Дополнительные методы, если нужно
}
