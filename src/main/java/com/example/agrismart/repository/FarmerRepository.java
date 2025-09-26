package com.example.agrismart.repository;

import com.example.agrismart.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
  Optional<Farmer> findByUsername(String username);
}
