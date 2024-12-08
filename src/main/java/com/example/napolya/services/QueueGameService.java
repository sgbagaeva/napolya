package com.example.napolya.services;

import com.example.napolya.model.QueueGame;
import com.example.napolya.repositories.QueueGameRepository;
import org.springframework.stereotype.Service;

@Service
public class QueueGameService extends GenericService<QueueGame, Integer> {
    private final QueueGameRepository queueGameRepository;

    public QueueGameService(QueueGameRepository queueGameRepository) {
        super(queueGameRepository);
        this.queueGameRepository = queueGameRepository;
    }
}

