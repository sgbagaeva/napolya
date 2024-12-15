package com.example.napolya.services;

import com.example.napolya.model.User;
import com.example.napolya.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends GenericService<User, Integer>{
    private final UserRepository playerRepository;

    public UserService(UserRepository playerRepository) {
        super(playerRepository); // Передаем конкретный репозиторий в базовый класс
        this.playerRepository = playerRepository; // Инициализируем поле
    }
    // Метод для поиска пользователя по имени
    public Optional<User> findByName(String name) {
        return playerRepository.findByName(name);
    }
    // Метод для поиска пользователя по email
    public Optional<User> findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }
}