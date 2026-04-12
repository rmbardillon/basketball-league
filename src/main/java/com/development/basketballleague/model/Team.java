package com.development.basketballleague.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    
    @NotBlank(message = "Team name is required")
    private String name;
    
    @NotNull(message = "League ID is required")
    private String leagueId;
}