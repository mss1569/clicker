package com.mss1569.clicker.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
class UserTest {

    @Test
    void setId(){
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        user.setId(1L);

        Assertions.assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    void getId(){
        User user = User.builder()
                .id(5L)
                .build();

        Assertions.assertThat(user.getId()).isEqualTo(5L);
    }

    @Test
    void setPoints(){
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        user.setPoints(10);

        Assertions.assertThat(user.getPoints()).isEqualTo(10);
    }

    @Test
    void getPoints(){
        User user = User.builder()
                .points(50)
                .build();

        Assertions.assertThat(user.getPoints()).isEqualTo(50);
    }

    @Test
    void setUsername(){
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        user.setUsername("user");

        Assertions.assertThat(user.getUsername()).isEqualTo("user");
    }

    @Test
    void getUsername(){
        User user = User.builder()
                .username("teste")
                .build();

        Assertions.assertThat(user.getUsername()).isEqualTo("teste");
    }

    @Test
    void setPassword(){
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        user.setPassword("password");

        Assertions.assertThat(user.getPassword()).isEqualTo("password");
    }
    @Test
    void getPassword(){
        User user = User.builder()
                .password("senha")
                .build();

        Assertions.assertThat(user.getPassword()).isEqualTo("senha");
    }

    @Test
    void getAuthorities() {
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        Assertions.assertThat(user.getAuthorities()).isEqualTo(Collections.emptyList());
    }

    @Test
    void isAccountNonExpired() {
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        Assertions.assertThat(user.isAccountNonExpired()).isTrue();
    }

    @Test
    void isAccountNonLocked() {
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        Assertions.assertThat(user.isAccountNonLocked()).isTrue();
    }

    @Test
    void isCredentialsNonExpired() {
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        Assertions.assertThat(user.isCredentialsNonExpired()).isTrue();
    }

    @Test
    void isEnabled() {
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        Assertions.assertThat(user.isEnabled()).isTrue();
    }

    @Test
    void setAnt(){
        Ant ant = Ant.builder().build();
        User user = User.builder().build();

        user.setAnt(ant);

        Assertions.assertThat(user.getAnt()).isEqualTo(ant);
    }

    @Test
    void getAnt(){
        Ant ant = Ant.builder().build();
        User user = User.builder()
                .ant(ant)
                .build();

        Assertions.assertThat(user.getAnt()).isEqualTo(ant);
    }
}