package org.pragadeesh.fitnesstracker.controller;

import org.pragadeesh.fitnesstracker.model.JwtResponse;
import org.pragadeesh.fitnesstracker.model.User;
import org.pragadeesh.fitnesstracker.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody User user) {
        return ResponseEntity.ok(authenticationService.login(user));
    }
}
