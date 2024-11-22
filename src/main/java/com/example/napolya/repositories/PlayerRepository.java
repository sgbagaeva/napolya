package com.example.napolya.repositories;

import com.example.napolya.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Player findByEmail(String email); // Находим игрока по электронной почте
}
