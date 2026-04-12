package com.development.basketballleague.dto;

import com.development.basketballleague.model.Player;
import lombok.Data;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Data
public class BatchUploadPlayersRequest {
    @NotEmpty(message = "Players list cannot be empty")
    @Valid
    private List<Player> players;
}