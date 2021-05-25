package com.example.demo.response;

import com.example.demo.entity.Custom;

public class CustomIfoResponse {
  private Long id;
  private String fullName;
  private String email;
  private String phone;

  public CustomIfoResponse(Custom custom) {
    this.id = custom.getId();
    this.fullName = custom.getFull_name();
    this.email = custom.getEmail();
    this.phone = custom.getPhone();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
