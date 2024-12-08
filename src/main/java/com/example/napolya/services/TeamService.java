package com.example.napolya.services;

import com.example.napolya.model.Team;
import com.example.napolya.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService extends GenericService<Team, Integer> {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        super(teamRepository);
        this.teamRepository = teamRepository;
    }
    // Метод для поиска команды по названию
    public Optional<Team> findByName(String name) {
        return teamRepository.findByName(name);
    }
    // Метод для поиска команды по ID игры (пока что считаем, что 1 команда на 1 игру)
    public Optional<Team> findByGameId(Integer gameId) {
        return teamRepository.findByGameId(gameId);
    }
}
