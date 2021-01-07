package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.exception.ObjectFoundException;
import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepositoryMock;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .id(1L)
                .username("matheus")
                .password("senha")
                .build();

        BDDMockito.when(userRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(user));

        BDDMockito.when(userRepositoryMock.existsByUsername(ArgumentMatchers.anyString()))
                .thenReturn(false);

        BDDMockito.when(userRepositoryMock.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(user);

        BDDMockito.when(userRepositoryMock.save(ArgumentMatchers.any(User.class)))
                .thenReturn(user);

        BDDMockito.doNothing().when(userRepositoryMock).delete(ArgumentMatchers.any(User.class));
    }

    @Test
    void loadUserByUsername() {
        UserDetails user = userService.loadUserByUsername("matheus");

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    void loadUserByUsernameNotFound() {
        BDDMockito.when(userRepositoryMock.findByUsername(ArgumentMatchers.anyString()))
                .thenReturn(null);

        Assertions.assertThatExceptionOfType(UsernameNotFoundException.class)
                .isThrownBy(() -> userService.loadUserByUsername("nenhum"));
    }

    @Test
    void findById() {
        User user = userService.findById(1L);

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    void findByIdNotFound() {
        BDDMockito.when(userRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(ObjectNotFoundException.class)
                .isThrownBy(() -> userService.findById(2L));
    }

    @Test
    void save() {
        User userSaved = userService.save(user);

        Assertions.assertThat(userSaved).isNotNull().isEqualTo(user);
    }

    @Test
    void saveFail() {
        BDDMockito.when(userRepositoryMock.existsByUsername(ArgumentMatchers.anyString()))
                .thenReturn(true);

        Assertions.assertThatExceptionOfType(ObjectFoundException.class)
                .isThrownBy(() -> userService.save(user));
    }

    @Test
    void delete() {
        Assertions.assertThatCode(() -> userService.delete(1L))
                .doesNotThrowAnyException();
    }
}