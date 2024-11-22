package com.example.napolya.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Уникальный идентификатор команды

    private String name; // Название команды

    @ElementCollection
    private List<Integer> playerIds; // ID игроков, входящих в команду

    private Integer gameId; // ID игры, в которой участвует команда

    private Integer captainId; // ID капитана команды

    // Getters и Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Integer> getPlayerIds() {
        return playerIds;
    }
    public void setPlayerIds(List<Integer> playerIds) {
        this.playerIds = playerIds;
    }
    public int getGamesId() {
        return gameId;
    }
    public void setGamesId(int gameId) {
        this.gameId = gameId;
    }
    public int getCaptainId() {
        return captainId;
    }
    public void setCaptainId(int captainId) {
        this.captainId = captainId;
    }
}
