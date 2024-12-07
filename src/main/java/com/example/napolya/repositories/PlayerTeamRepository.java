package com.example.napolya.repositories;

import com.example.napolya.model.PlayerTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerTeamRepository extends CrudRepository<PlayerTeam, Integer> {
    // Дополнительные методы, если нужно
}
