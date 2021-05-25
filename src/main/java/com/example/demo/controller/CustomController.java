package com.example.demo.controller;

import com.example.demo.entity.Custom;
import com.example.demo.service.CustomService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomController {
  private final CustomService customService;

  public CustomController(CustomService customService) {
    this.customService = customService;
  }

  @PostMapping("/api/customers")
  public ResponseEntity<?> createCustomer(@RequestBody Custom custom) {
      return ResponseEntity.ok(customService.createCustomer(custom));
  }

  @GetMapping("/api/customers")
  public ResponseEntity<?> readAllCustomers() {

    return ResponseEntity.ok(customService.readAllCustomers());
  }

  @GetMapping("/api/customers/{id}")
  public ResponseEntity<?> readCustomer(@PathVariable Long id) {

    return ResponseEntity.ok(customService.readCustomer(id));
  }

  @PutMapping("/api/customers/{id}")
  public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Custom custom) {
    return ResponseEntity.ok(customService.updateCustomer(custom, id));
  }


  @DeleteMapping("/api/customers/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customService.deleteCustomer(id);
  }
}
