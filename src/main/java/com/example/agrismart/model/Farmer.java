package com.example.agrismart.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "farmer")
public class Farmer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(name = "soil_type")
  private String soilType;

  @Column(name = "land_area")
  private Integer landArea;

  @Column(name = "location_city")
  private String locationCity;

  @Column(name = "location_state")
  private String locationState;
}

