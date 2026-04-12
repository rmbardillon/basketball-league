package com.development.basketballleague.dto;

import lombok.Data;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
public class BatchAddPlayersToTeamRequest {
    @NotNull(message = "Team ID is required")
    private String teamId;
    
    @NotNull(message = "League ID is required")
    private String leagueId;
    
    @NotEmpty(message = "Player assignments list cannot be empty")
    @Valid
    private List<PlayerAssignment> playerAssignments;
    
    @Data
    public static class PlayerAssignment {
        @NotNull(message = "Player ID is required")
        private String playerId;
        
        @NotNull(message = "Jersey number is required")
        private Integer jerseyNumber;
    }
}