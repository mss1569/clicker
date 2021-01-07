package com.mss1569.clicker.controller;

import com.mss1569.clicker.DTO.UserPostRegister;
import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.mapper.UserMapper;
import com.mss1569.clicker.service.AntService;
import com.mss1569.clicker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="clicker")
@RequiredArgsConstructor
public class ClickerController {
    private final AntService antService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping(path = "register")
    public ResponseEntity<Void> register(@RequestBody UserPostRegister user) {
        User userToSave = userMapper.toUser(user);
        userToSave.setAnt(antService.save(Ant.builder().build()));
        userService.save(userToSave);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}