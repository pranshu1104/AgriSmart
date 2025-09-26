package com.example.agrismart.repository;

import com.example.agrismart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);  // already used in AuthService

  boolean existsByUsername(String username);       // ✅ add this
}
