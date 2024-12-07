package com.example.napolya.repositories;

import com.example.napolya.model.Field;
import com.example.napolya.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer> {
    // Метод для поиска поля по названию
    Optional<Field> findByName(String name);
}
