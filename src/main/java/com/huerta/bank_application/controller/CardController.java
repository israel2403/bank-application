package com.huerta.bank_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/card")
public class CardController {

  @GetMapping
  public String getCard() {
    return "Here are the card details from the database";
  }
}
