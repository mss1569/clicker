package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.exception.ObjectFoundException;
import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        return Optional.ofNullable(userRepository.findByUsername(s))
                .orElseThrow(()->new UsernameNotFoundException("Username already exists"));
    }

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Transactional
    public User save(User user) {
        if (userRepository.existsByUsername(user.getUsername()))
            throw new ObjectFoundException("Username already exists");

        userRepository.save(user);

        return user;
    }

    public void delete(long id) {
        User userToDelete = findById(id);

        userRepository.delete(userToDelete);
    }
}