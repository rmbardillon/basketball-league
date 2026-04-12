package com.development.basketballleague.controller;

import com.development.basketballleague.dto.BatchUploadPlayersRequest;
import com.development.basketballleague.dto.BatchUploadPlayersResponse;
import com.development.basketballleague.model.Player;
import com.development.basketballleague.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        return playerService.getPlayerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@Valid @RequestBody Player player) {
        return playerService.createPlayer(player);
    }
    
    @PostMapping("/batch")
    public ResponseEntity<BatchUploadPlayersResponse> batchUploadPlayers(
            @Valid @RequestBody BatchUploadPlayersRequest request) {
        BatchUploadPlayersResponse response = playerService.batchUploadPlayers(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable String id, @Valid @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}