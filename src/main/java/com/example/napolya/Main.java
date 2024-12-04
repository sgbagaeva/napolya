package com.example.napolya;

import com.example.napolya.model.Player;
import com.example.napolya.repositories.PlayerRepository;


import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        // Ваш код для создания и сохранения игрока
        Player player = new Player();
        player.setName("John");
        player.setSurname("Doe");
        player.setEmail("john.doe@example.com");
        player.setPassword("password"); // НИКОГДА не храните пароли в открытом виде!
        player.setRole("USER");
        player.setRegistrationDate(LocalDateTime.now());
        player.setRating(0);
        player.setEntriesAmount(0);

        //playerRepository.save(player);
        System.out.println("Player saved: " + player.getName() + " " + player.getSurname());
    }
}

