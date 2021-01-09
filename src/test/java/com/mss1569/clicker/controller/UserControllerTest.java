package com.mss1569.clicker.controller;

import com.mss1569.clicker.DTO.UserPostRequest;
import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.mapper.UserMapper;
import com.mss1569.clicker.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userServiceMock;
    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private User user;
    private UserPostRequest userPostRequest;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L)
                .username("teste")
                .password("teste")
                .build();

        userPostRequest = UserPostRequest.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        BDDMockito.when(userServiceMock.save(ArgumentMatchers.any(User.class)))
                .thenReturn(user);

        BDDMockito.when(userServiceMock.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(user);
    }

    @Test
    void findMe() {
        User userFound = userController.findMe(user).getBody();

        Assertions.assertThat(userFound).isNotNull();
        Assertions.assertThat(userFound.getId()).isNotNull().isEqualTo(user.getId());
    }

    @Test
    void save() {
        User userSaved = userController.save(userPostRequest).getBody();

        Assertions.assertThat(userSaved).isNotNull().isEqualTo(user);
    }
}