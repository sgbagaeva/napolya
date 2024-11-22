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

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String email;

    private String password; // Необходимо будет хэшировать пароли.

    private String role;

    private LocalDateTime registrationDate;

    private int rating;

    /*@ElementCollection
    private List<Integer> gamesIds;*/ // Список ID игр, на которые записан игрок.

    @ElementCollection
    @CollectionTable(name = "players", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "games_ids")
    // переделать, когда появится база данных
    private List<Integer> teamsIds; // ID команд, в которых состоит игрок.

    @ElementCollection
    private List<Integer> queuesIds; // Список ID игр, на которые записан игрок.

    private int entriesAmount; // Количество записей на игры.

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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    /*public List<Integer> getGamesIds() {
        return gamesIds;
    }
    public void setGamesIds(List<Integer> gamesIds) {
        this.gamesIds = gamesIds;
    }*/
    public List<Integer> getTeamsIds() {
        return teamsIds;
    }
    public void setTeamsIds(List<Integer> teamsIds) {
        this.teamsIds = teamsIds;
    }
    public List<Integer> getQueuesIds() {
        return queuesIds;
    }
    public void setQueuesIds(List<Integer> queuesIds) {
        this.queuesIds = queuesIds;
    }
    public int getEntriesAmount() {
        return entriesAmount;
    }
    public void setEntriesAmount(Integer entriesAmount) {
        this.entriesAmount = entriesAmount;
    }
}
