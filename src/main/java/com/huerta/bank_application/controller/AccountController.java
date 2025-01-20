package com.huerta.bank_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

  @GetMapping
  public String getAccount() {
    return "Here are the account details from the database";
  }
}
