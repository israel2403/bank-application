package com.huerta.bank_application.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

  private String email;
  private String pwd;
  private String role;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
