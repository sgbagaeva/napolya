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
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Уникальный идентификатор игры

    private String name; // Название игры

    private String description; // Описание игры

    private LocalDateTime startDate; // Дата и время начала игры

    private String status; // Статус игры (например, "активная", "завершена")

    /*@ElementCollection
    private List<Integer> participantsIds;*/ // ID участников игры

    private int creatorId; // ID создателя игры

    private int fieldId; // ID поля, на котором будет проводиться игра

    @ElementCollection
    private List<Integer> teamsIds; // ID команд, участвующих в игре
    private int queueId; // ID очереди на игру

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
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    /*public List<Integer> getParticipantsIds() {
        return participantsIds;
    }
    public void setParticipantsIds(List<Long> participantsIds) {
        this.participantsIds = participantsIds;
    }*/
    public int getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
    public int getFieldId() {
        return fieldId;
    }
    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }
    public List<Integer> getTeamsIds() {
        return teamsIds;
    }
    public void setTeamsIds(List<Integer> teamsIds) {
        this.teamsIds = teamsIds;
    }
    public int getQueueId() {
        return queueId;
    }
    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }
}
