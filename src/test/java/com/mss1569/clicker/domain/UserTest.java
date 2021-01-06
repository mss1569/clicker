package com.mss1569.clicker.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void setId(){
        User user = User.builder().build();

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
        User user = User.builder().build();

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
        User user = User.builder().build();

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
        User user = User.builder().build();

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

    @Test
    void getAuthorities() {
        User user = User.builder().build();

        Assertions.assertThat(user.getAuthorities()).isEqualTo(null);
    }

    @Test
    void isAccountNonExpired() {
        User user = User.builder().build();

        Assertions.assertThat(user.isAccountNonExpired()).isEqualTo(true);
    }

    @Test
    void isAccountNonLocked() {
        User user = User.builder().build();

        Assertions.assertThat(user.isAccountNonLocked()).isEqualTo(true);
    }

    @Test
    void isCredentialsNonExpired() {
        User user = User.builder().build();

        Assertions.assertThat(user.isCredentialsNonExpired()).isEqualTo(true);
    }

    @Test
    void isEnabled() {
        User user = User.builder().build();

        Assertions.assertThat(user.isEnabled()).isEqualTo(true);
    }
}