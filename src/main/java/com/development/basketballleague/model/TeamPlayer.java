package com.development.basketballleague.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
@Document(collection = "team_players")
public class TeamPlayer {
    @Id
    private String id;
    
    @NotNull(message = "Team ID is required")
    private String teamId;
    
    @NotNull(message = "Player ID is required")
    private String playerId;
    
    @NotNull(message = "League ID is required")
    private String leagueId;
    
    @NotNull(message = "Jersey number is required")
    @Min(value = 0, message = "Jersey number must be at least 0")
    @Max(value = 99, message = "Jersey number must be at most 99")
    private Integer jerseyNumber;
}