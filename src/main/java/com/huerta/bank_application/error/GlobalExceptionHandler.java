package com.huerta.bank_application.error;

import java.time.LocalDateTime;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleGlobalException(
      final Exception ex, WebRequest webRequest) {
    final ErrorResponseDTO errorResponseDTO =
        ErrorResponseDTO.builder()
            .apiPath(webRequest.getDescription(false))
            .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
            .errorMessage(ex.getMessage())
            .errorTime(LocalDateTime.now())
            .errors(Collections.emptyList())
            .build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
  }

  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<ErrorResponseDTO> handleUsernameNotFoundException(
      final UsernameNotFoundException ex, WebRequest webRequest) {
    final ErrorResponseDTO errorResponseDTO =
        ErrorResponseDTO.builder()
            .apiPath(webRequest.getDescription(false))
            .errorCode(HttpStatus.NOT_FOUND)
            .errorMessage(ex.getMessage())
            .errorTime(LocalDateTime.now())
            .errors(Collections.emptyList()) // No field errors needed for this exception
            .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponseDTO> handleIllegalArgumentException(
      final IllegalArgumentException ex, WebRequest webRequest) {
    final ErrorResponseDTO errorResponseDTO =
        ErrorResponseDTO.builder()
            .apiPath(webRequest.getDescription(false))
            .errorCode(HttpStatus.BAD_REQUEST)
            .errorMessage(ex.getMessage())
            .errorTime(LocalDateTime.now())
            .errors(Collections.emptyList()) // No field errors needed for this exception
            .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
  }
}
