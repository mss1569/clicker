package com.mss1569.clicker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ant {
    public static final double PRICE_PER_LEVEL_MULTIPLIER = 2;
    public static final double POINTS_PER_LEVEL_MULTIPLIER = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level = 0;

    public void upgrade(){
        level++;
    }

    public double getUpgradePrice(){
        return Math.pow(PRICE_PER_LEVEL_MULTIPLIER, level);
    }

    public double getPointsPerClick(){
        return (level * POINTS_PER_LEVEL_MULTIPLIER) + 1;
    }
}
