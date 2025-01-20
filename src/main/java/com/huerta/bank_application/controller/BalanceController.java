package com.huerta.bank_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/balance")
public class BalanceController {

  @GetMapping
  public String getBalance() {
    return "Here are the balance details from the database";
  }
}
