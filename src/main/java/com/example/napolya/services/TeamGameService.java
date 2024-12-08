package com.example.napolya.services;

import com.example.napolya.model.TeamGame;
import com.example.napolya.repositories.TeamGameRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamGameService extends GenericService<TeamGame, Integer> {
    private final TeamGameRepository teamGameRepository;

    public TeamGameService(TeamGameRepository teamGameRepository) {
        super(teamGameRepository);
        this.teamGameRepository = teamGameRepository;
    }
}

