package com.development.basketballleague.service;

import com.development.basketballleague.dto.UpdateGameScoreRequest;
import com.development.basketballleague.model.Game;
import com.development.basketballleague.model.GameStatus;
import com.development.basketballleague.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(String id) {
        return gameRepository.findById(id);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGameScore(String id, UpdateGameScoreRequest request) {
        Optional<Game> gameOpt = gameRepository.findById(id);
        if (gameOpt.isPresent()) {
            Game game = gameOpt.get();
            game.setScoreA(request.getScoreA());
            game.setScoreB(request.getScoreB());
            game.setStatus(GameStatus.FINISHED);
            return gameRepository.save(game);
        }
        throw new RuntimeException("Game not found with id: " + id);
    }

    public List<Game> getGamesByLeague(String leagueId) {
        return gameRepository.findByLeagueId(leagueId);
    }

    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }
}