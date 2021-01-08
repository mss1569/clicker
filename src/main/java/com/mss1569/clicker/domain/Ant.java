package com.mss1569.clicker.domain;

import com.mss1569.clicker.exception.UpgradeException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private double points = 0;

    @NotNull
    @OneToOne
    private User user;

    public void click() {
        points += getPointsPerClick();
    }

    public double getPointsPerClick() {
        return (level * POINTS_PER_LEVEL_MULTIPLIER) + 1;
    }

    public void upgrade() {
        if (!canUpgrade())
            throw new UpgradeException("Upgrade error");

        subtractPoints(getUpgradePrice());
        incrementLevel();
    }

    public void subtractPoints(double pointsToSubtract){
        points -= pointsToSubtract;
    }

    public void incrementLevel(){
        level++;
    }

    public boolean canUpgrade() {
        return points >= getUpgradePrice();
    }

    public double getUpgradePrice() {
        return Math.pow(PRICE_PER_LEVEL_MULTIPLIER, level);
    }
}
