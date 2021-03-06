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
class AntRepositoryTest {
    @Autowired
    private AntRepository antRepository;

    @Autowired
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    void setUp(){
        user = User.builder()
                .username("teste")
                .password("senha")
                .build();
        userRepository.save(user);
    }

    @AfterEach
    void cleanUp(){
        userRepository.delete(user);
    }

    @Test
    void save(){
        Ant antToSave = Ant.builder()
                .user(user)
                .build();

        Ant antSaved = antRepository.save(antToSave);

        Assertions.assertThat(antSaved).isNotNull();
        Assertions.assertThat(antSaved.getId()).isNotNull();
        Assertions.assertThat(antSaved.getLevel()).isZero();
    }

    @Test
    void update(){
        Ant antToSave = Ant.builder()
                .user(user)
                .build();
        Ant antSaved = antRepository.save(antToSave);
        antSaved.setLevel(5);

        Ant antUpdated = antRepository.save(antSaved);

        Assertions.assertThat(antUpdated).isNotNull();
        Assertions.assertThat(antUpdated.getId()).isEqualTo(antSaved.getId());
        Assertions.assertThat(antUpdated.getLevel()).isEqualTo(antSaved.getLevel());
    }

    @Test
    void delete(){
        Ant antToSave = Ant.builder()
                .user(user)
                .build();
        Ant antSaved = antRepository.save(antToSave);

        antRepository.delete(antSaved);

        Optional<Ant> antOptional = antRepository.findById(antSaved.getId());
        Assertions.assertThat(antOptional).isEmpty();
    }

    @Test
    void findByUserUsername(){
        Ant antToSave = Ant.builder()
                .user(user)
                .build();
        Ant antSaved = antRepository.save(antToSave);

        Ant antFound = antRepository.findByUserUsername(user.getUsername());

        Assertions.assertThat(antFound).isNotNull();
        Assertions.assertThat(antFound.getId()).isNotNull();
        Assertions.assertThat(antFound.getId()).isEqualTo(antSaved.getId());
        Assertions.assertThat(antFound.getUser().getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    void existsByUserIdFalse(){
        Ant antToSave = Ant.builder()
                .user(user)
                .build();
        Ant antSaved = antRepository.save(antToSave);
        boolean existsAnt = antRepository.existsByUserId(85L);

        Assertions.assertThat(existsAnt).isFalse();
    }

    @Test
    void existsByUserIdTrue(){
        Ant antToSave = Ant.builder()
                .user(user)
                .build();
        Ant antSaved = antRepository.save(antToSave);
        boolean existsAnt = antRepository.existsByUserId(user.getId());

        Assertions.assertThat(existsAnt).isTrue();
    }
}