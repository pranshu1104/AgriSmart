package com.example.agrismart.model.AuthDtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {
  @NotBlank
  private String username;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String password;

  @NotBlank
  private String soilType;

  @NotNull
  @Min(value = 1, message = "Land area must be greater than 0")
  private Integer landArea;

  private String Location;
}
