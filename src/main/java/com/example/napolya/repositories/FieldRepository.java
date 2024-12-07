package com.example.napolya.repositories;

import com.example.napolya.model.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer> {
    // Дополнительные методы для Game, если нужно
    Optional<Field> findByName(String name);
}
