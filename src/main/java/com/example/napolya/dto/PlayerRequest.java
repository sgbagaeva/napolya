package com.example.napolya.dto;

public class PlayerRequest {
    private Integer id;

    // Конструкторы, геттеры и сеттеры

    public PlayerRequest(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}