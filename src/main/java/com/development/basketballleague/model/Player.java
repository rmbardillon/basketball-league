package com.development.basketballleague.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Data
@Document(collection = "players")
public class Player {
    @Id
    private String id;
    
    @NotBlank(message = "Player name is required")
    private String name;
    
    private String position;
}