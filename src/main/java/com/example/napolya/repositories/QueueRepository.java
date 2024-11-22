package com.example.napolya.repositories;

import com.example.napolya.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Integer> {
}
