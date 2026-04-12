package com.development.basketballleague.repository;

import com.development.basketballleague.model.PlayerStats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatsRepository extends MongoRepository<PlayerStats, String> {
    List<PlayerStats> findByGameId(String gameId);
    List<PlayerStats> findByPlayerId(String playerId);
}