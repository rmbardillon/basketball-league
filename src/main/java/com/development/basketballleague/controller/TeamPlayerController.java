package com.development.basketballleague.controller;

import com.development.basketballleague.dto.AddPlayerToTeamRequest;
import com.development.basketballleague.dto.BatchAddPlayersToTeamRequest;
import com.development.basketballleague.dto.BatchAddPlayersToTeamResponse;
import com.development.basketballleague.model.TeamPlayer;
import com.development.basketballleague.service.TeamPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/roster")
@RequiredArgsConstructor
public class TeamPlayerController {
    private final TeamPlayerService teamPlayerService;

    @PostMapping("/add-player")
    public TeamPlayer addPlayerToTeam(@Valid @RequestBody AddPlayerToTeamRequest request) {
        return teamPlayerService.addPlayerToTeam(request);
    }
    
    @PostMapping("/test-batch")
    public ResponseEntity<String> testBatch() {
        return ResponseEntity.ok("Batch endpoint authentication works!");
    }
    
    @PostMapping("/batch-add-players")
    public ResponseEntity<BatchAddPlayersToTeamResponse> batchAddPlayersToTeam(
            @RequestBody BatchAddPlayersToTeamRequest request) {
        System.out.println("Batch endpoint called");
        BatchAddPlayersToTeamResponse response = teamPlayerService.batchAddPlayersToTeam(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/team/{teamId}")
    public List<TeamPlayer> getTeamRoster(@PathVariable String teamId) {
        return teamPlayerService.getTeamRoster(teamId);
    }

    @GetMapping("/league/{leagueId}")
    public List<TeamPlayer> getLeagueRosters(@PathVariable String leagueId) {
        return teamPlayerService.getLeagueRosters(leagueId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePlayerFromTeam(@PathVariable String id) {
        teamPlayerService.removePlayerFromTeam(id);
        return ResponseEntity.noContent().build();
    }
}