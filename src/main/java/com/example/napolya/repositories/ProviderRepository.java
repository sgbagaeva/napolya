package com.example.napolya.repositories;

import com.example.napolya.model.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Integer> {
    // Дополнительные методы для Provider, если нужно
    Optional<Provider> findByName(String name);
}