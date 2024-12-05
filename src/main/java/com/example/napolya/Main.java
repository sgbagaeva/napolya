package com.example.napolya;

import com.example.napolya.model.Game;
import com.example.napolya.model.Player;
import com.example.napolya.repositories.PlayerRepository;


import java.time.LocalDateTime;
import java.util.Optional;

import com.example.napolya.services.GameService;
import com.example.napolya.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Приложение запустилось");

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

        playerService.createPlayer(player);
        System.out.println("Player saved: " + player.getName() + " " + player.getSurname());

        Game game = new Game();
        game.setName("Adventure Game");
        game.setDescription("An exciting adventure game with many challenges.");
        game.setStartDate(LocalDateTime.now().plusDays(1)); // Например, игра начинается через 1 день
        game.setStatus(Game.StatusEnum.valueOf("активная"));
        game.setCreatorId(1); // ID создателя игры (например, ID игрока или пользователя)
        game.setFieldId(2); // ID поля (например, ID игрового поля или локации)
        game.setQueueId(3); // ID очереди (например, ID очереди, если у вас есть система очередей)

        // Сохранение игры
        //gameService.createGame(game);

        //System.out.println("Game saved: " + game.getName() + ", Description: " + game.getDescription());
    }
}

