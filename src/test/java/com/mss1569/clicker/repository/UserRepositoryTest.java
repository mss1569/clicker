package com.mss1569.clicker.repository;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AntRepository antRepository;

    private Ant ant;

    @BeforeEach
    void setUp(){
        ant = Ant.builder()
                .build();
        antRepository.save(ant);
    }

    @AfterEach
    void cleanUp(){
        antRepository.delete(ant);
    }

    @Test
    void save(){
        User userToSave = User.builder()
                .username("testgge")
                .password("tesaaaate")
                .ant(ant)
                .build();

        User userSaved = userRepository.save(userToSave);

        Assertions.assertThat(userSaved).isNotNull();
        Assertions.assertThat(userSaved.getId()).isNotNull();
        Assertions.assertThat(userSaved.getUsername()).isEqualTo(userToSave.getUsername());
        Assertions.assertThat(userSaved.getPassword()).isEqualTo(userToSave.getPassword());
        Assertions.assertThat(userSaved.getPoints()).isEqualTo(userToSave.getPoints());
    }

    @Test
    void update(){
        User userToSave = User.builder()
                .username("teste")
                .password("testesss")
                .ant(ant)
                .build();
        User userSaved = userRepository.save(userToSave);

        userSaved.setPoints(50);

        User userUpdated = userRepository.save(userSaved);

        Assertions.assertThat(userUpdated).isNotNull();
        Assertions.assertThat(userUpdated.getId()).isEqualTo(userSaved.getId());
        Assertions.assertThat(userUpdated.getPoints()).isEqualTo(userSaved.getPoints());
    }

    @Test
    void delete(){
        User userToSave = User.builder()
                .username("testeaaa")
                .password("teste")
                .ant(ant)
                .build();
        User userSaved = userRepository.save(userToSave);

        userRepository.delete(userSaved);

        Optional<User> antOptional = userRepository.findById(userSaved.getId());
        Assertions.assertThat(antOptional).isEmpty();
    }

    @Test
    void findByUsername(){
        User userToSave = User.builder()
                .username("testgge")
                .password("tesaaaate")
                .ant(ant)
                .build();

        User userSaved = userRepository.save(userToSave);
        User user = userRepository.findByUsername(userSaved.getUsername());

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    void findByUsernameNotFound(){
        User userToSave = User.builder()
                .username("testgge")
                .password("tesaaaate")
                .ant(ant)
                .build();

        userRepository.save(userToSave);
        User user = userRepository.findByUsername("nenhum");

        Assertions.assertThat(user).isNull();
    }

    @Test
    void existsByUsernameFalse(){
        User userToSave = User.builder()
                .username("testgge")
                .password("tesaaaate")
                .ant(ant)
                .build();

        userRepository.save(userToSave);
        boolean existsUser = userRepository.existsByUsername("nenhum");

        Assertions.assertThat(existsUser).isFalse();
    }

    @Test
    void existsByUsernameTrue(){
        User userToSave = User.builder()
                .username("testgge")
                .password("tesaaaate")
                .ant(ant)
                .build();

        userRepository.save(userToSave);
        boolean existsUser = userRepository.existsByUsername(userToSave.getUsername());

        Assertions.assertThat(existsUser).isTrue();
    }
}