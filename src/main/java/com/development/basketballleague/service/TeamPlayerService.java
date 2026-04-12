package com.development.basketballleague.service;

import com.development.basketballleague.dto.AddPlayerToTeamRequest;
import com.development.basketballleague.dto.BatchAddPlayersToTeamRequest;
import com.development.basketballleague.dto.BatchAddPlayersToTeamResponse;
import com.development.basketballleague.model.TeamPlayer;
import com.development.basketballleague.repository.TeamPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamPlayerService {
    private final TeamPlayerRepository teamPlayerRepository;

    public TeamPlayer addPlayerToTeam(AddPlayerToTeamRequest request) {
        TeamPlayer teamPlayer = new TeamPlayer();
        teamPlayer.setTeamId(request.getTeamId());
        teamPlayer.setPlayerId(request.getPlayerId());
        teamPlayer.setLeagueId(request.getLeagueId());
        teamPlayer.setJerseyNumber(request.getJerseyNumber());
        return teamPlayerRepository.save(teamPlayer);
    }

    public List<TeamPlayer> getTeamRoster(String teamId) {
        return teamPlayerRepository.findByTeamId(teamId);
    }

    public List<TeamPlayer> getLeagueRosters(String leagueId) {
        return teamPlayerRepository.findByLeagueId(leagueId);
    }

    public void removePlayerFromTeam(String id) {
        teamPlayerRepository.deleteById(id);
    }
    
    public BatchAddPlayersToTeamResponse batchAddPlayersToTeam(BatchAddPlayersToTeamRequest request) {
        List<TeamPlayer> addedPlayers = new ArrayList<>();
        List<String> errors = new ArrayList<>();
        int successfulAssignments = 0;
        int failedAssignments = 0;
        
        for (int i = 0; i < request.getPlayerAssignments().size(); i++) {
            try {
                BatchAddPlayersToTeamRequest.PlayerAssignment assignment = request.getPlayerAssignments().get(i);
                
                // Validate jersey number range
                if (assignment.getJerseyNumber() < 0 || assignment.getJerseyNumber() > 99) {
                    errors.add("Assignment at index " + i + ": Jersey number must be between 0 and 99");
                    failedAssignments++;
                    continue;
                }
                
                // Check if jersey number is already taken in this team
                boolean jerseyTaken = teamPlayerRepository.findByTeamId(request.getTeamId())
                    .stream()
                    .anyMatch(tp -> tp.getJerseyNumber().equals(assignment.getJerseyNumber()));
                
                if (jerseyTaken) {
                    errors.add("Assignment at index " + i + ": Jersey number " + assignment.getJerseyNumber() + " is already taken");
                    failedAssignments++;
                    continue;
                }
                
                // Check if player is already on this team
                boolean playerAlreadyOnTeam = teamPlayerRepository.findByTeamId(request.getTeamId())
                    .stream()
                    .anyMatch(tp -> tp.getPlayerId().equals(assignment.getPlayerId()));
                
                if (playerAlreadyOnTeam) {
                    errors.add("Assignment at index " + i + ": Player is already on this team");
                    failedAssignments++;
                    continue;
                }
                
                // Create and save the team player assignment
                TeamPlayer teamPlayer = new TeamPlayer();
                teamPlayer.setTeamId(request.getTeamId());
                teamPlayer.setPlayerId(assignment.getPlayerId());
                teamPlayer.setLeagueId(request.getLeagueId());
                teamPlayer.setJerseyNumber(assignment.getJerseyNumber());
                
                TeamPlayer savedTeamPlayer = teamPlayerRepository.save(teamPlayer);
                addedPlayers.add(savedTeamPlayer);
                successfulAssignments++;
                
            } catch (Exception e) {
                errors.add("Assignment at index " + i + ": " + e.getMessage());
                failedAssignments++;
            }
        }
        
        return new BatchAddPlayersToTeamResponse(
            request.getPlayerAssignments().size(),
            successfulAssignments,
            failedAssignments,
            addedPlayers,
            errors
        );
    }
}