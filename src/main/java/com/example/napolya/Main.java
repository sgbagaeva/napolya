package com.example.napolya;

import com.example.napolya.model.Field;
import com.example.napolya.model.Game;
import com.example.napolya.model.Player;

import java.time.LocalDateTime;
import java.time.Month;

import com.example.napolya.model.Provider;
import com.example.napolya.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private  PlayerTeamService playerTeamService;


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Приложение запустилось");

        // Ваш код для создания и сохранения игрока
        Player player = new Player();
        player.setName("Георгий");
        player.setSurname("Багаев");
        player.setEmail("gvbagaev@example.com");
        player.setPassword("papa"); // НИКОГДА не хранить пароли в открытом виде!
        player.setRole("PLAYER");
        player.setRegistrationDate(LocalDateTime.now());
        player.setRating(156);
        player.setEntriesAmount(0);
        player.setAkkId(479);

        //playerService.save(player);
        //System.out.println("Player saved: " + player.getName() + " " + player.getSurname());

        Game game = new Game();
        game.setName("Праздничная игра");
        game.setDescription("И, как обычно, в начале декабря будет игра в честь Дня Рождения ПЕТРОВа " +
                "(Леве – 70!!!), которая состоится в восчкресенье, 8 декабря в 12-00 в " +
                "Гатчинском футбольном манеже (город Гатчина, улица Новоселов, 8Б). " +
                "Это будет не просто игра – это День Гатчины на Поляне. " +
                "Приглашаются все желающие поздравить именинника и обыграть его на футбольном поле. " +
                "Приходите все!");
        game.setStartDate(LocalDateTime.of(2024, Month.DECEMBER, 8, 12, 0));
        game.setStatus("активная");
        game.setCreatorId(1); // ID создателя игры (например, ID игрока или пользователя)
        game.setFieldId(2); // ID поля (например, ID игрового поля или локации)
        //game.setQueueId(3); // ID очереди (например, ID очереди, если у вас есть система очередей)

        // Сохранение игры
        //gameService.saveGame(game);

        //System.out.println("Game saved: " + game.getName() + ", Description: " + game.getDescription());
        //System.out.println(gameService.getAllGames());
        Provider provider = new Provider();
        provider.setName("Интерспорт");
        //providerService.save(provider);

        // Создание нового экземпляра класса Field
        Field field = new Field();

        field.setName("Гатчинский футбольный манеж"); // Установка имени поля
        field.setDescription("Зимний зал"); // Установка описания поля
        field.setLocation("улица Новоселов, 8Б, Гатчина"); // Установка местоположения поля
        field.setProviderId(1); // ID поставщика (например, ID организации, которая предоставляет поле)

        //fieldService.deleteById(5);
        //System.out.println(gameService.findAll());
    }
}

