package com.example.napolya.repositories;

import com.example.napolya.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByName(String name);
    // Метод для поиска игрока по email
    Optional<User> findByEmail(String email);
}
