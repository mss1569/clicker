package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.repository.AntRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
                .build();

        BDDMockito.when(antRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(ant));

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
    void delete() {
        Assertions.assertThatCode(() -> antService.delete(1L))
                .doesNotThrowAnyException();
    }
}