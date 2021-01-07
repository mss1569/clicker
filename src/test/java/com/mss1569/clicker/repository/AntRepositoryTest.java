package com.mss1569.clicker.repository;

import com.mss1569.clicker.domain.Ant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class AntRepositoryTest {
    @Autowired
    private AntRepository antRepository;

    @Test
    void save(){
        Ant antToSave = Ant.builder()
                .build();

        Ant antSaved = antRepository.save(antToSave);

        Assertions.assertThat(antSaved).isNotNull();
        Assertions.assertThat(antSaved.getId()).isNotNull();
        Assertions.assertThat(antSaved.getLevel()).isEqualTo(0);
    }

    @Test
    void update(){
        Ant antToSave = Ant.builder()
                .build();
        Ant antSaved = antRepository.save(antToSave);
        antSaved.upgrade();

        Ant antUpdated = antRepository.save(antSaved);

        Assertions.assertThat(antUpdated).isNotNull();
        Assertions.assertThat(antUpdated.getId()).isEqualTo(antSaved.getId());
        Assertions.assertThat(antUpdated.getLevel()).isEqualTo(antSaved.getLevel());
    }

    @Test
    void delete(){
        Ant antToSave = Ant.builder()
                .build();
        Ant antSaved = antRepository.save(antToSave);

        antRepository.delete(antSaved);

        Optional<Ant> antOptional = antRepository.findById(antSaved.getId());
        Assertions.assertThat(antOptional).isEmpty();
    }
}