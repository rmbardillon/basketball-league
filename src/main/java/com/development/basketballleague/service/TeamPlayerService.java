package com.development.basketballleague.service;

import com.development.basketballleague.dto.AddPlayerToTeamRequest;
import com.development.basketballleague.model.TeamPlayer;
import com.development.basketballleague.repository.TeamPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}