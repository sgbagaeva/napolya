package com.example.napolya.services;

import com.example.napolya.model.Field;
import com.example.napolya.model.Game;
import com.example.napolya.repositories.FieldRepository;
import com.example.napolya.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FieldService {
    private final FieldRepository fieldRepository;

    @Autowired
    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    // Метод для сохранения нового поля
    public Field savefield(Field field) {
        return fieldRepository.save(field);
    }

    // Метод для получения всех полей
    public List<Field> getAllFields() {
        List<Field> fields = new ArrayList<>();
        fieldRepository.findAll().forEach(fields::add);
        return fields;
    }

    // Метод для получения поля по ID
    public Optional<Field> getFieldById(Integer id) {
        return fieldRepository.findById(id);
    }

    // Метод для обновления поля
    public Field updateField(Field field) {
        // Проверяем, существует ли поле
        if (!fieldRepository.existsById(field.getId())) {
            throw new RuntimeException("Field not found with ID: " + field.getId());
        }
        return fieldRepository.save(field);
    }

    // Метод для удаления поля
    public void deleteField(Integer id) {
        if (!fieldRepository.existsById(id)) {
            throw new RuntimeException("Field not found with ID: " + id);
        }
        fieldRepository.deleteById(id);
    }

    // Метод для поиска поля по названию
    public Optional<Field> findByName(String name) {
        return fieldRepository.findByName(name);
    }
}

