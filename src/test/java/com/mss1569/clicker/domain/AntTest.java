package com.mss1569.clicker.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class AntTest {
    @Test
    void successLv1Upgrade(){
        Ant ant = Ant.builder()
                .level(1)
                .build();

        ant.upgrade();

        Assertions.assertThat(ant.getLevel()).isEqualTo(2);
    }

    @Test
    void successLv2Upgrade(){
        Ant ant = Ant.builder()
                .level(2)
                .build();

        ant.upgrade();

        Assertions.assertThat(ant.getLevel()).isEqualTo(3);
    }

    @Test
    void getUpgradePriceLv1(){
        Ant ant = Ant.builder()
                .level(1)
                .build();

        Assertions.assertThat(ant.getUpgradePrice()).isEqualTo(2.0);
    }

    @Test
    void getUpgradePriceLv2(){
        Ant ant = Ant.builder()
                .level(2)
                .build();

        Assertions.assertThat(ant.getUpgradePrice()).isEqualTo(4.0);
    }

    @Test
    void getPointsPerClickLv1(){
        Ant ant = Ant.builder()
                .level(1)
                .build();

        Assertions.assertThat(ant.getPointsPerClick()).isEqualTo(10.0);
    }

    @Test
    void getPointsPerClickLv2(){
        Ant ant = Ant.builder()
                .level(2)
                .build();

        Assertions.assertThat(ant.getPointsPerClick()).isEqualTo(20.0);
    }

    @Test
    void setId(){
        Ant ant = Ant.builder().build();

        ant.setId(1L);

        Assertions.assertThat(ant.getId()).isEqualTo(1L);
    }

    @Test
    void getId(){
        Ant ant = Ant.builder()
                .id(3L)
                .build();

        Assertions.assertThat(ant.getId()).isEqualTo(3L);
    }

    @Test
    void setLevel(){
        Ant ant = Ant.builder().build();

        ant.setLevel(10);

        Assertions.assertThat(ant.getLevel()).isEqualTo(10);
    }

    @Test
    void getLevel(){
        Ant ant = Ant.builder()
                .level(5)
                .build();

        Assertions.assertThat(ant.getLevel()).isEqualTo(5);
    }
}