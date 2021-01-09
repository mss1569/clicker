package com.mss1569.clicker.controller;

import com.mss1569.clicker.DTO.UserPostRequest;
import com.mss1569.clicker.domain.User;
import com.mss1569.clicker.mapper.UserMapper;
import com.mss1569.clicker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping(path = "user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(path="/me")
    public ResponseEntity<User> findMe(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(userService.findByUsername(userDetails.getUsername()));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequest userPostRequest){
        return ResponseEntity.ok(userService.save(userMapper.toUser(userPostRequest)));
    }
}

