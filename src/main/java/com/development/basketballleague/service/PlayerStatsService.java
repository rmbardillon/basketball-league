package com.development.basketballleague.service;

import com.development.basketballleague.model.PlayerStats;
import com.development.basketballleague.repository.PlayerStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerStatsService {
    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStats addPlayerStats(PlayerStats playerStats) {
        return playerStatsRepository.save(playerStats);
    }

    public List<PlayerStats> getStatsByGame(String gameId) {
        return playerStatsRepository.findByGameId(gameId);
    }

    public List<PlayerStats> getStatsByPlayer(String playerId) {
        return playerStatsRepository.findByPlayerId(playerId);
    }

    public Optional<PlayerStats> getStatsById(String id) {
        return playerStatsRepository.findById(id);
    }

    public PlayerStats updatePlayerStats(String id, PlayerStats playerStats) {
        playerStats.setId(id);
        return playerStatsRepository.save(playerStats);
    }

    public void deletePlayerStats(String id) {
        playerStatsRepository.deleteById(id);
    }
}