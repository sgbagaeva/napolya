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
@Table(name = "queues") // Название таблицы в БД
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Уникальный идентификатор очереди

    @ElementCollection
    private List<Integer> playersIds; // ID игроков, находящихся в очереди

    private Long gameId; // ID игры, на которую стоит очередь

    // Getters и Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Integer> getPlayersIds() {
        return playersIds;
    }
    public void setPlayersIds(List<Integer> playersIds) {
        this.playersIds = playersIds;
    }
    public Long getGameId() {
        return gameId;
    }
    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}