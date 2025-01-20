package com.huerta.bank_application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notice")
public class NoticeController {

  @GetMapping
  public String getNotice() {
    return "Here are the notice details from the database";
  }
}
