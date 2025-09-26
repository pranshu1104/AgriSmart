package com.example.agrismart.controller;

import com.example.agrismart.model.RegisterRequest;
import com.example.agrismart.model.LoginRequest;
import com.example.agrismart.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authService.register(request.getUsername(), request.getPassword()));
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request.getUsername(), request.getPassword()));
  }
}
