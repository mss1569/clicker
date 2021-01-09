package com.mss1569.clicker.controller;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.service.AntService;
import com.mss1569.clicker.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AntControllerTest {
    @InjectMocks
    private AntController antController;
    @Mock
    private AntService antServiceMock;
    @Mock
    private UserService userServiceMock;

    private User user;
    private Ant ant;

    AntControllerTest() {
    }

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L)
                .username("teste")
                .password("teste")
                .build();

        ant = Ant.builder()
                .user(user)
                .build();

        BDDMockito.when(antServiceMock.save(ArgumentMatchers.any(Ant.class)))
                .thenReturn(ant);

        BDDMockito.when(userServiceMock.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(user);

        BDDMockito.when(antServiceMock.findByUserUsername(ArgumentMatchers.anyString()))
                .thenReturn(ant);

        BDDMockito.when(antServiceMock.click(ArgumentMatchers.any(Ant.class)))
                .thenReturn(ant);

        BDDMockito.when(antServiceMock.upgrade(ArgumentMatchers.any(Ant.class)))
                .thenReturn(ant);

        BDDMockito.when(antServiceMock.findByUserUsername(ArgumentMatchers.anyString()))
                .thenReturn(ant);
    }

    @Test
    void save() {
        Ant antSaved = antController.save(user).getBody();

        Assertions.assertThat(antSaved).isNotNull().isEqualTo(ant);
    }

    @Test
    void info() {
        Ant antSaved = antController.info(user).getBody();

        Assertions.assertThat(antSaved).isNotNull().isEqualTo(ant);
    }

    @Test
    void clickLv0() {
        Ant antClicked = antController.click(user).getBody();

        Assertions.assertThat(antClicked).isNotNull();
    }

    @Test
    void clickLv1() {
        Ant antClicked = antController.click(user).getBody();

        Assertions.assertThat(antClicked).isNotNull();
    }

    @Test
    void upgradeLv0() {
        Ant antUpgraded = antController.upgrade(user).getBody();

        Assertions.assertThat(antUpgraded).isNotNull();
    }
}