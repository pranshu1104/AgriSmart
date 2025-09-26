package com.example.agrismart.controller;

import com.example.agrismart.model.LoginRequest;
import com.example.agrismart.model.RegisterRequest;
import com.example.agrismart.model.User;
import com.example.agrismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  // ================== REGISTER ==================
  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
    if (userRepository.existsByUsername(request.getUsername())) {
      return ResponseEntity.badRequest().body("Username already exists");
    }

    User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setLandArea(request.getLandArea());
    user.setSoilType(request.getSoilType());

    userRepository.save(user);

    return ResponseEntity.ok("User registered successfully!");
  }

  // ================== LOGIN ==================
  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@RequestBody LoginRequest request) {
    User user = userRepository.findByUsername(request.getUsername())
      .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
      return ResponseEntity.badRequest().body("Invalid username or password");
    }

    return ResponseEntity.ok("Login successful!");
  }
}
