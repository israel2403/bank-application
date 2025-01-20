package com.huerta.bank_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/loan")
public class LoanController {

  @GetMapping
  public String getLoan() {
    return "Here are the loan details from the database";
  }
}
