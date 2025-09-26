package com.example.agrismart.service;

import com.example.agrismart.model.RegisterRequest;
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

  public String register(RegisterRequest request) {
    String username = request.getUsername();
    if (userRepository.findByUsername(username).isPresent()) {
      throw new RuntimeException("Username already exists!");
    }

    User user = new User();   // ✅ use User, not Farmer
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setSoilType(request.getSoilType());
    user.setLandArea(request.getLandArea());   // keep as Double
    user.setLocationCity("Gurgaon");           // placeholder, later from request
    // user.setLocationState("Haryana");       // only if you add this field

    userRepository.save(user);
    return "User registered successfully!";
  }

  public String login(String username, String password) {
    User user = userRepository.findByUsername(username)   // ✅ use User
      .orElseThrow(() -> new RuntimeException("User not found!"));

    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException("Invalid credentials!");
    }
    return "Login successful!";
  }
}
