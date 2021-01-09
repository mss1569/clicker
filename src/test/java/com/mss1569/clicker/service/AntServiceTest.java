package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.exception.ObjectFoundException;
import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.repository.AntRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class AntServiceTest {
    @InjectMocks
    private AntService antService;
    @Mock
    private AntRepository antRepositoryMock;

    private Ant ant;

    @BeforeEach
    void setUp() {
        ant = Ant.builder()
                .id(1L)
                .user(User.builder()
                        .id(1L)
                        .username("teste")
                        .password("teste")
                        .build())
                .build();

        BDDMockito.when(antRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(ant));

        BDDMockito.when(antRepositoryMock.findByUserUsername(ArgumentMatchers.anyString()))
                .thenReturn(ant);

        BDDMockito.when(antRepositoryMock.save(ArgumentMatchers.any(Ant.class)))
                .thenReturn(ant);

        BDDMockito.doNothing().when(antRepositoryMock).delete(ArgumentMatchers.any(Ant.class));
    }

    @Test
    void save() {
        Ant antSaved = antService.save(ant);

        Assertions.assertThat(antSaved).isNotNull().isEqualTo(ant);
    }

    @Test
    void saveFail() {
        BDDMockito.when(antRepositoryMock.existsByUserId(ArgumentMatchers.anyLong()))
                .thenReturn(true);

        Assertions.assertThatExceptionOfType(ObjectFoundException.class)
                .isThrownBy(() -> antService.save(ant));
    }

    @Test
    void delete() {
        Assertions.assertThatCode(() -> antService.delete(1L))
                .doesNotThrowAnyException();
    }

    @Test
    void click(){
        Ant antClicker = antService.click(ant);

        Assertions.assertThat(antClicker.getPoints()).isEqualTo(1);
    }

    @Test
    void upgrade(){
        ant.setPoints(2);

        Ant antUpgraded = antService.upgrade(ant);

        Assertions.assertThat(antUpgraded.getPoints()).isEqualTo(1);
        Assertions.assertThat(antUpgraded.getLevel()).isEqualTo(1);
    }

    @Test
    void findByUsername() {
        Ant ant = antService.findByUserUsername("matheus");

        Assertions.assertThat(ant).isNotNull();
    }

    @Test
    void findByUsernameNotFound() {
        BDDMockito.when(antRepositoryMock.findByUserUsername(ArgumentMatchers.anyString()))
                .thenReturn(null);

        Assertions.assertThatExceptionOfType(ObjectNotFoundException.class)
                .isThrownBy(() -> antService.findByUserUsername("nenhum"));
    }
}