package com.example.napolya.repositories;

import com.example.napolya.model.Player;
import com.example.napolya.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {
    // Дополнительные методы для Team, если нужно
    Optional<Team> findByName(String name);
}
