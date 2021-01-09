package com.mss1569.clicker.controller;

import com.mss1569.clicker.domain.Ant;
import com.mss1569.clicker.service.AntService;
import com.mss1569.clicker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "ant")
public class AntController {
    private final AntService antService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Ant> save(@AuthenticationPrincipal UserDetails userDetails){
        Ant ant = Ant.builder()
                .user(userService.findByUsername(userDetails.getUsername()))
                .build();
        return ResponseEntity.ok(antService.save(ant));
    }

    @GetMapping(path = "info")
    public ResponseEntity<Ant> info(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(antService.findByUserUsername(userDetails.getUsername()));
    }

    @GetMapping(path = "click")
    public ResponseEntity<Ant> click(@AuthenticationPrincipal UserDetails userDetails){
        Ant ant = antService.findByUserUsername(userDetails.getUsername());
        return ResponseEntity.ok(antService.click(ant));
    }

    @GetMapping(path = "upgrade")
    public ResponseEntity<Ant> upgrade(@AuthenticationPrincipal UserDetails userDetails){
        Ant ant = antService.findByUserUsername(userDetails.getUsername());
        return ResponseEntity.ok(antService.upgrade(ant));
    }
}
