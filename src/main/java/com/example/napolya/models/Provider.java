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
@Table(name = "providers") // Название таблицы в БД
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Уникальный идентификатор провайдера

    private String name; // Название провайдера

    @ElementCollection
    private List<Integer> fieldsIds; // ID полей, которые предоставляет провайдер

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
    public List<Integer> getFieldsIds() {
        return fieldsIds;
    }
    public void setFieldsIds(List<Integer> fieldsIds) {
        this.fieldsIds = fieldsIds;
    }
}
