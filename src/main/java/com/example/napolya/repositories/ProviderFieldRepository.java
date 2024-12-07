package com.example.napolya.repositories;

import com.example.napolya.model.ProviderField;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderFieldRepository extends CrudRepository<ProviderField, Integer> {
    // Дополнительные методы, если нужно
}
