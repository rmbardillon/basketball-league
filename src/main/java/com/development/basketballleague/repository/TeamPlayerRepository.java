package com.development.basketballleague.repository;

import com.development.basketballleague.model.TeamPlayer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamPlayerRepository extends MongoRepository<TeamPlayer, String> {
    List<TeamPlayer> findByTeamId(String teamId);
    List<TeamPlayer> findByLeagueId(String leagueId);
    List<TeamPlayer> findByPlayerId(String playerId);
}