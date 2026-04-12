package com.development.basketballleague.controller;

import com.development.basketballleague.dto.UpdateGameScoreRequest;
import com.development.basketballleague.model.Game;
import com.development.basketballleague.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable String id) {
        return gameService.getGameById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Game createGame(@Valid @RequestBody Game game) {
        return gameService.createGame(game);
    }

    @PutMapping("/{id}/score")
    public Game updateGameScore(@PathVariable String id, @Valid @RequestBody UpdateGameScoreRequest request) {
        return gameService.updateGameScore(id, request);
    }

    @GetMapping("/league/{leagueId}")
    public List<Game> getGamesByLeague(@PathVariable String leagueId) {
        return gameService.getGamesByLeague(leagueId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable String id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}