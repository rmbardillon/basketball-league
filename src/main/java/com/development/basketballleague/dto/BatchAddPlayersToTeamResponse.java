package com.development.basketballleague.dto;

import com.development.basketballleague.model.TeamPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BatchAddPlayersToTeamResponse {
    private int totalAssignments;
    private int successfulAssignments;
    private int failedAssignments;
    private List<TeamPlayer> addedPlayers;
    private List<String> errors;
}