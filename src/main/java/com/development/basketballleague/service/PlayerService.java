package com.development.basketballleague.service;

import com.development.basketballleague.dto.BatchUploadPlayersRequest;
import com.development.basketballleague.dto.BatchUploadPlayersResponse;
import com.development.basketballleague.model.Player;
import com.development.basketballleague.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(String id) {
        return playerRepository.findById(id);
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(String id, Player player) {
        player.setId(id);
        return playerRepository.save(player);
    }

    public void deletePlayer(String id) {
        playerRepository.deleteById(id);
    }
    
    public BatchUploadPlayersResponse batchUploadPlayers(BatchUploadPlayersRequest request) {
        List<Player> uploadedPlayers = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        int successfulUploads = 0;
        int failedUploads = 0;
        
        for (int i = 0; i < request.getPlayers().size(); i++) {
            try {
                Player player = request.getPlayers().get(i);
                
                // Validate required fields
                if (player.getName() == null || player.getName().trim().isEmpty()) {
                    errors.add("Player at index " + i + ": Name is required");
                    failedUploads++;
                    continue;
                }
                
                if (player.getPosition() == null || player.getPosition().trim().isEmpty()) {
                    errors.add("Player at index " + i + ": Position is required");
                    failedUploads++;
                    continue;
                }
                
                // Save the player
                Player savedPlayer = playerRepository.save(player);
                uploadedPlayers.add(savedPlayer);
                successfulUploads++;
                
            } catch (Exception e) {
                errors.add("Player at index " + i + ": " + e.getMessage());
                failedUploads++;
            }
        }
        
        return new BatchUploadPlayersResponse(
            request.getPlayers().size(),
            successfulUploads,
            failedUploads,
            uploadedPlayers,
            errors
        );
    }
}