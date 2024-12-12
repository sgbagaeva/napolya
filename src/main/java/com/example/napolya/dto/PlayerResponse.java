package com.example.napolya.dto;

public class PlayerResponse {
    private String nickname;
    private String nameAndSurname;
    private Integer rating;

    // Конструкторы, геттеры и сеттеры

    public PlayerResponse(String nickname, String nameAndSurname, Integer rating) {
        this.nickname = nickname;
        this.nameAndSurname = nameAndSurname;
        this.rating = rating;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}