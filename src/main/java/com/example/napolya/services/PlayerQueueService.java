package com.example.napolya.services;

import com.example.napolya.model.PlayerQueue;
import com.example.napolya.repositories.PlayerQueueRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerQueueService extends GenericService<PlayerQueue, Integer> {
    private final PlayerQueueRepository playerQueueRepository;

    public PlayerQueueService(PlayerQueueRepository playerQueueRepository) {
        super(playerQueueRepository);
        this.playerQueueRepository = playerQueueRepository;
    }
}

