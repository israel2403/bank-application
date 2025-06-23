package com.huerta.bank_application.service;

import com.huerta.bank_application.dto.UserDTO;
import com.huerta.bank_application.entity.Customer;
import com.huerta.bank_application.repository.CustomerRepository;
import com.huerta.bank_application.request.CustomerRequest;
import com.huerta.bank_application.utils.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;

  public UserDTO register(final CustomerRequest customerRequest) {
    log.info("Starting user registration process for email: {}", customerRequest.getEmail());

    // Map CustomerRequest to Customer entity
    Customer customer = UserMapper.mapToCustomer.apply(customerRequest);
    log.debug("Mapped Customer entity: {}", customer);

    log.info("Checking password value {} already exists", customer.getPwd());

    // Encode the password
    encodePassword(customer, customerRequest.getPwd());
    log.debug("Encoded password for customer: {}", customer.getEmail());

    // Save the customer to the database
    customerRepository.save(customer);
    log.info("Customer saved successfully with ID: {}", customer.getId());

    // Map Customer entity to UserDTO
    UserDTO userDTO = UserMapper.userDto.apply(customer);
    log.debug("Mapped UserDTO: {}", userDTO);

    log.info(
        "User registration process completed successfully for email: {}",
        customerRequest.getEmail());
    return userDTO;
  }

  private void encodePassword(Customer customer, String rawPassword) {
    if (rawPassword == null || rawPassword.isBlank()) {
      throw new IllegalArgumentException("Password cannot be null or blank");
    }
    customer.setPwd(passwordEncoder.encode(rawPassword));
  }
}
