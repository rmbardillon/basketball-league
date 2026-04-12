package com.development.basketballleague.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

@Data
public class UpdateGameScoreRequest {
    @NotNull(message = "Score A is required")
    @Min(value = 0, message = "Score A must be non-negative")
    private Integer scoreA;
    
    @NotNull(message = "Score B is required")
    @Min(value = 0, message = "Score B must be non-negative")
    private Integer scoreB;
}