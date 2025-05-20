package com.huerta.bank_application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huerta.bank_application.dto.UserDTO;
import com.huerta.bank_application.request.CustomerRequest;
import com.huerta.bank_application.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);

  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserDTO> register(@RequestBody final CustomerRequest customer) {
    log.info("Received registration request for email: {}", customer.getEmail());
    final UserDTO userDTO = this.userService.register(customer);
    log.info("User registration process completed successfully for email: {}", customer.getEmail());
    return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
  }
}
