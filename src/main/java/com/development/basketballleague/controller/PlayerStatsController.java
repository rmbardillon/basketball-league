package com.development.basketballleague.controller;

import com.development.basketballleague.model.PlayerStats;
import com.development.basketballleague.service.PlayerStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/player-stats")
@RequiredArgsConstructor
public class PlayerStatsController {
    private final PlayerStatsService playerStatsService;

    @PostMapping
    public PlayerStats addPlayerStats(@Valid @RequestBody PlayerStats playerStats) {
        return playerStatsService.addPlayerStats(playerStats);
    }

    @GetMapping("/game/{gameId}")
    public List<PlayerStats> getStatsByGame(@PathVariable String gameId) {
        return playerStatsService.getStatsByGame(gameId);
    }

    @GetMapping("/player/{playerId}")
    public List<PlayerStats> getStatsByPlayer(@PathVariable String playerId) {
        return playerStatsService.getStatsByPlayer(playerId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerStats> getStatsById(@PathVariable String id) {
        return playerStatsService.getStatsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public PlayerStats updatePlayerStats(@PathVariable String id, @Valid @RequestBody PlayerStats playerStats) {
        return playerStatsService.updatePlayerStats(id, playerStats);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerStats(@PathVariable String id) {
        playerStatsService.deletePlayerStats(id);
        return ResponseEntity.noContent().build();
    }
}