package com.example.agrismart.service;

import com.example.agrismart.model.AuthDtos.RegisterRequest;
import com.example.agrismart.model.Farmer;
import com.example.agrismart.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private FarmerRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private FarmerRepository farmerRepository;

  public String register(RegisterRequest request) {
    String username = request.getUsername();
    if (farmerRepository.findByUsername(username).isPresent()) {
      throw new RuntimeException("Username already exists!");
    }
    Farmer user = new Farmer();
    user.setUsername(username);
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setSoilType(request.getSoilType());
    user.setLandArea(request.getLandArea());
    user.setLocationCity("Gurgaon");
    user.setLocationState("Haryana");
    userRepository.save(user);
    return "User registered successfully!";
  }

  public String login(String username, String password) {
    Farmer user = farmerRepository.findByUsername(username)
      .orElseThrow(() -> new RuntimeException("User not found!"));
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException("Invalid credentials!");
    }
    return "Login successful!";
  }
}
