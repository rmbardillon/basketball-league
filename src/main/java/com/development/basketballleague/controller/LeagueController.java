package com.development.basketballleague.controller;

import com.development.basketballleague.model.League;
import com.development.basketballleague.service.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/leagues")
@RequiredArgsConstructor
public class LeagueController {
    private final LeagueService leagueService;

    @GetMapping
    public List<League> getAllLeagues() {
        return leagueService.getAllLeagues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable String id) {
        return leagueService.getLeagueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public League createLeague(@Valid @RequestBody League league) {
        return leagueService.createLeague(league);
    }

    @PutMapping("/{id}")
    public League updateLeague(@PathVariable String id, @Valid @RequestBody League league) {
        return leagueService.updateLeague(id, league);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable String id) {
        leagueService.deleteLeague(id);
        return ResponseEntity.noContent().build();
    }
}