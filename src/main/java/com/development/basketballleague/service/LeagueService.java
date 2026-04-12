package com.development.basketballleague.service;

import com.development.basketballleague.model.League;
import com.development.basketballleague.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeagueService {
    private final LeagueRepository leagueRepository;

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public Optional<League> getLeagueById(String id) {
        return leagueRepository.findById(id);
    }

    public League createLeague(League league) {
        return leagueRepository.save(league);
    }

    public League updateLeague(String id, League league) {
        league.setId(id);
        return leagueRepository.save(league);
    }

    public void deleteLeague(String id) {
        leagueRepository.deleteById(id);
    }
}