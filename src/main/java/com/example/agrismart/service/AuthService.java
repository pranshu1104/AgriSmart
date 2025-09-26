package com.example.agrismart.service;

import com.example.agrismart.model.User;
import com.example.agrismart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public String register(String username, String password) {
    if (userRepository.findByUsername(username).isPresent()) {
      throw new RuntimeException("Username already exists!");
    }
    User user = new User();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(password));
    userRepository.save(user);
    return "User registered successfully!";
  }

  public String login(String username, String password) {
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new RuntimeException("User not found!"));
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException("Invalid credentials!");
    }
    return "Login successful!";
  }
}
