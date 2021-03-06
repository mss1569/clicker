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
        User user = User.builder()
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
    void setUsername(){
        User user = User.builder()
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
        User user = User.builder()
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
        User user = User.builder()
                .build();

        Assertions.assertThat(user.getAuthorities()).isEqualTo(Collections.emptyList());
    }

    @Test
    void isAccountNonExpired() {
        User user = User.builder()
                .build();

        Assertions.assertThat(user.isAccountNonExpired()).isTrue();
    }

    @Test
    void isAccountNonLocked() {
        User user = User.builder()
                .build();

        Assertions.assertThat(user.isAccountNonLocked()).isTrue();
    }

    @Test
    void isCredentialsNonExpired() {
        User user = User.builder()
                .build();

        Assertions.assertThat(user.isCredentialsNonExpired()).isTrue();
    }

    @Test
    void isEnabled() {
        User user = User.builder()
                .build();

        Assertions.assertThat(user.isEnabled()).isTrue();
    }
}