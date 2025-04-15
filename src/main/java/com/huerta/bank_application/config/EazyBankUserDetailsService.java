package com.huerta.bank_application.config;

import com.huerta.bank_application.entity.Customer;
import com.huerta.bank_application.repository.CustomerRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EazyBankUserDetailsService implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(EazyBankUserDetailsService.class);

  private final CustomerRepository customerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("Attempting to load user by username: {}", username);

    // Fetch customer from the repository
    Customer customer =
        customerRepository
            .findByEmail(username)
            .orElseThrow(
                () -> {
                  log.error("User not found: {}", username);
                  return new UsernameNotFoundException("User not found with email: " + username);
                });

    log.info("User found: {}", customer.getEmail());

    // Map the customer's role to GrantedAuthority
    List<GrantedAuthority> authorities =
        Collections.singletonList(new SimpleGrantedAuthority(customer.getRole()));

    // Return a Spring Security User object
    return new User(customer.getEmail(), customer.getPwd(), authorities);
  }
}
