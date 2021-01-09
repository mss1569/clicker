package com.mss1569.clicker.service;

import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.exception.ObjectFoundException;
import com.mss1569.clicker.exception.ObjectNotFoundException;
import com.mss1569.clicker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) {
        return Optional.ofNullable(userRepository.findByUsername(s))
                .orElseThrow(()->new UsernameNotFoundException("Username already exists"));
    }

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    @Transactional
    public User save(User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        if (userRepository.existsByUsername(user.getUsername()))
            throw new ObjectFoundException("Username already exists");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public void delete(long id) {
        User userToDelete = findById(id);

        userRepository.delete(userToDelete);
    }
}