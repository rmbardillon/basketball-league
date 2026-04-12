package com.development.basketballleague.dto;

import com.development.basketballleague.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BatchUploadPlayersResponse {
    private int totalPlayers;
    private int successfulUploads;
    private int failedUploads;
    private List<Player> uploadedPlayers;
    private List<String> errors;
}