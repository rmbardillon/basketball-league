package com.development.basketballleague.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
public class AddPlayerToTeamRequest {
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