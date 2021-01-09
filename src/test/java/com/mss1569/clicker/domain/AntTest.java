package com.mss1569.clicker.domain;

import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.exception.UpgradeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AntTest {
    @Test
    void successLv1Upgrade() {
        Ant ant = Ant.builder()
                .level(1)
                .points(2.0)
                .build();

        ant.upgrade();

        Assertions.assertThat(ant.getLevel()).isEqualTo(2);
        Assertions.assertThat(ant.getPoints()).isZero();
    }

    @Test
    void failLv1Upgrade() {
        Ant ant = Ant.builder()
                .level(1)
                .points(1)
                .build();

        Assertions.assertThatExceptionOfType(UpgradeException.class)
                .isThrownBy(() -> ant.upgrade());
    }

    @Test
    void successLv2Upgrade() {
        Ant ant = Ant.builder()
                .level(2)
                .points(5)
                .build();

        ant.upgrade();

        Assertions.assertThat(ant.getLevel()).isEqualTo(3);
        Assertions.assertThat(ant.getPoints()).isEqualTo(1.0);
    }

    @Test
    void failLv2Upgrade() {
        Ant ant = Ant.builder()
                .level(2)
                .points(3)
                .build();

        Assertions.assertThatExceptionOfType(UpgradeException.class)
                .isThrownBy(() -> ant.upgrade());
    }

    @Test
    void getUpgradePriceLv1() {
        Ant ant = Ant.builder()
                .level(1)
                .build();

        Assertions.assertThat(ant.getUpgradePrice()).isEqualTo(2.0);
    }

    @Test
    void getUpgradePriceLv2() {
        Ant ant = Ant.builder()
                .level(2)
                .build();

        Assertions.assertThat(ant.getUpgradePrice()).isEqualTo(4.0);
    }

    @Test
    void getPointsPerClickLv1() {
        Ant ant = Ant.builder()
                .level(1)
                .build();

        Assertions.assertThat(ant.getPointsPerClick()).isEqualTo(11.0);
    }

    @Test
    void getPointsPerClickLv2() {
        Ant ant = Ant.builder()
                .level(2)
                .build();

        Assertions.assertThat(ant.getPointsPerClick()).isEqualTo(21.0);
    }

    @Test
    void clickLv0() {
        Ant ant = Ant.builder()
                .level(0)
                .points(0)
                .build();

        ant.click();

        Assertions.assertThat(ant.getPoints()).isEqualTo(1);
    }

    @Test
    void clickLv2() {
        Ant ant = Ant.builder()
                .level(2)
                .points(9)
                .build();

        ant.click();

        Assertions.assertThat(ant.getPoints()).isEqualTo(30);
    }

    @Test
    void setId() {
        Ant ant = Ant.builder()
                .build();

        ant.setId(1L);

        Assertions.assertThat(ant.getId()).isEqualTo(1L);
    }

    @Test
    void getId() {
        Ant ant = Ant.builder()
                .id(3L)
                .build();

        Assertions.assertThat(ant.getId()).isEqualTo(3L);
    }

    @Test
    void setLevel() {
        Ant ant = Ant.builder()
                .build();

        ant.setLevel(10);

        Assertions.assertThat(ant.getLevel()).isEqualTo(10);
    }

    @Test
    void getLevel() {
        Ant ant = Ant.builder()
                .level(5)
                .build();

        Assertions.assertThat(ant.getLevel()).isEqualTo(5);
    }

    @Test
    void setPoints() {
        Ant ant = Ant.builder()
                .build();

        ant.setPoints(10);

        Assertions.assertThat(ant.getPoints()).isEqualTo(10);
    }

    @Test
    void getPoints() {
        Ant ant = Ant.builder()
                .points(5)
                .build();

        Assertions.assertThat(ant.getPoints()).isEqualTo(5);
    }

    @Test
    void setUser() {
        User user = User.builder()
                .username("teste")
                .password("teste")
                .build();
        Ant ant = Ant.builder()
                .build();

        ant.setUser(user);

        Assertions.assertThat(ant.getUser()).isEqualTo(user);
    }

    @Test
    void getUser() {
        User user = User.builder()
                .username("teste")
                .password("teste")
                .build();
        Ant ant = Ant.builder()
                .user(user)
                .build();

        Assertions.assertThat(ant.getUser()).isEqualTo(user);
    }
}