package com.example.napolya.services;

import com.example.napolya.model.Field;
import com.example.napolya.repositories.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FieldService extends GenericService<Field, Integer> {
    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        super(fieldRepository);
        this.fieldRepository = fieldRepository;
    }
    // Метод для поиска поля по названию
    public Optional<Field> findByName(String name) {
        return fieldRepository.findByName(name);
    }
}

