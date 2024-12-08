package com.example.napolya.services;

import com.example.napolya.model.PlayerTeam;
import com.example.napolya.repositories.PlayerTeamRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerTeamService extends GenericService<PlayerTeam, Integer> {
    private final PlayerTeamRepository playerTeamRepository;

    public PlayerTeamService(PlayerTeamRepository playerTeamRepository) {
        super(playerTeamRepository);
        this.playerTeamRepository = playerTeamRepository;
    }
}

