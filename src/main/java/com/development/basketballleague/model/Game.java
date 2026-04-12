package com.development.basketballleague.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@Document(collection = "games")
public class Game {
    @Id
    private String id;
    
    @NotNull(message = "League ID is required")
    private String leagueId;
    
    @NotNull(message = "Team A ID is required")
    private String teamAId;
    
    @NotNull(message = "Team B ID is required")
    private String teamBId;
    
    @Min(value = 0, message = "Score A must be non-negative")
    private Integer scoreA = 0;
    
    @Min(value = 0, message = "Score B must be non-negative")
    private Integer scoreB = 0;
    
    @NotNull(message = "Game date is required")
    private LocalDateTime gameDate;
    
    @NotBlank(message = "Venue is required")
    private String venue;
    
    @NotNull(message = "Game status is required")
    private GameStatus status = GameStatus.SCHEDULED;
}