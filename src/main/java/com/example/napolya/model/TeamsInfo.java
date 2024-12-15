package com.example.napolya.model;

import com.example.napolya.services.PlayerTeamService;
import com.example.napolya.services.TeamService;
import com.example.napolya.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamsInfo {
    // Вывод данных состоит из:
    // 1. названий команд
    // 2. имени капитана каждой команды
    // 3. состава игроков каждой команды
    @Autowired
    private UserService userService;

    @Autowired
    private PlayerTeamService playerTeamService;

    @Autowired
    private TeamService teamService;

    public List<Team> getTeamsByGameId(Integer gameId) {
        return teamService.findAll()
                .stream()
                .filter(team -> gameId.equals(team.getGameId()))
                .toList();
    }

    public User getCaptainByTeamId(Integer teamId) {
        Team team = teamService.findById(teamId).orElse(null);
        assert team != null;
        Integer captainId = team.getCaptainId();
        User captain = userService.findById(captainId).orElse(null);

        assert captain != null;
        return captain;
    }

    public List<User> getPlayersByTeamId(Integer teamId) {

        List<Integer> playerIds = playerTeamService.findAll()
                .stream()
                .filter(playerTeam -> teamId.equals(playerTeam.getTeamId()))
                .map(PlayerTeam::getPlayerId)
                .toList();

        List<User> players = new ArrayList<>();

        for (Integer playerId : playerIds) {
            User user = userService.findById(playerId).orElse(null);
            assert user != null;
            players.add(user);
        }

        return players;
    }
}
