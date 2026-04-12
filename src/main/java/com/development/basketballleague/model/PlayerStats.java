package com.development.basketballleague.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Data
@Document(collection = "player_stats")
public class PlayerStats {
    @Id
    private String id;
    
    @NotNull(message = "Player ID is required")
    private String playerId;
    
    @NotNull(message = "Game ID is required")
    private String gameId;
    
    @Min(value = 0, message = "Points must be non-negative")
    private Integer points = 0;
    
    @Min(value = 0, message = "Rebounds must be non-negative")
    private Integer rebounds = 0;
    
    @Min(value = 0, message = "Assists must be non-negative")
    private Integer assists = 0;
    
    @Min(value = 0, message = "Steals must be non-negative")
    private Integer steals = 0;
    
    @Min(value = 0, message = "Blocks must be non-negative")
    private Integer blocks = 0;
    
    @Min(value = 0, message = "Three pointers made must be non-negative")
    private Integer threePointersMade = 0;
}