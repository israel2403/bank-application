package com.huerta.bank_application.utils;

import com.huerta.bank_application.dto.UserDTO;
import com.huerta.bank_application.entity.Customer;
import com.huerta.bank_application.request.CustomerRequest;
import java.util.function.Function;

public interface UserMapper {
  Function<CustomerRequest, Customer> mapToCustomer =
      newCustomer -> {
        Customer mappedCustomer = new Customer();
        mappedCustomer.setEmail(newCustomer.getEmail());
        mappedCustomer.setPwd(newCustomer.getPwd());
        mappedCustomer.setRole(newCustomer.getRole());
        return mappedCustomer;
      };

  Function<Customer, UserDTO> userDto =
      newCustomer -> {
        UserDTO mappedUser = new UserDTO();
        mappedUser.setEmail(newCustomer.getEmail());
        mappedUser.setPwd(newCustomer.getPwd());
        mappedUser.setRole(newCustomer.getRole());
        mappedUser.setCreatedAt(newCustomer.getCreatedAt());
        mappedUser.setUpdatedAt(newCustomer.getUpdatedAt());
        return mappedUser;
      };
}
