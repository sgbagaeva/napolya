package com.example.napolya.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "games")
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Уникальный идентификатор поля

    private String name; // Название поля

    private String description; // Описание поля

    private String location; // Адрес поля

    private int providerId; // ID провайдера поля
    @ElementCollection
    private List<Integer> gamesIds; // ID игр, проводимых на поле

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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getProviderId() {
        return providerId;
    }
    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
    public List<Integer> getGamesIds() {
        return gamesIds;
    }
    public void setGamesIds(List<Integer> gamesIds) {
        this.gamesIds = gamesIds;
    }
}