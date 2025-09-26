package com.example.agrismart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // table name
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private Double landArea;
  private String soilType;
  private String locationCity;  // <-- new field

  // Getters and setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }

  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }

  public String getFirstName() { return firstName; }
  public void setFirstName(String firstName) { this.firstName = firstName; }

  public String getLastName() { return lastName; }
  public void setLastName(String lastName) { this.lastName = lastName; }

  public Double getLandArea() { return landArea; }
  public void setLandArea(Double landArea) { this.landArea = landArea; }

  public String getSoilType() { return soilType; }
  public void setSoilType(String soilType) { this.soilType = soilType; }

  public String getLocationCity() { return locationCity; }  // <-- getter
  public void setLocationCity(String locationCity) { this.locationCity = locationCity; } // setter
}
