package com.example.demo.service;

import com.example.demo.entity.Custom;
import com.example.demo.repository.CustomRepository;
import com.example.demo.response.CustomIfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomService {
  private final CustomRepository customRepository;

  public CustomService(CustomRepository customRepository) {
    this.customRepository = customRepository;
  }

  @Transactional
  public CustomIfoResponse createCustomer(Custom custom){
    if (customRepository.getCustomByEmail(custom.getEmail()) == null) {
      Date date = new Date();
      custom.setCreated(date.getTime());
      return new CustomIfoResponse(customRepository.save(custom));
    }else {
      return null;
    }
  }

  @Transactional
  public List<CustomIfoResponse> readAllCustomers() {
    List<Custom> customs = (List<Custom>) customRepository.findAll();
    List<CustomIfoResponse> customIfoResponses = new ArrayList<>();
    for (Custom custom : customs) {
      customIfoResponses.add(new CustomIfoResponse(custom));
    }
    return customIfoResponses;
  }

  @Transactional
  public CustomIfoResponse readCustomer(Long id) {
    return new CustomIfoResponse(customRepository.getCustomById(id));
  }

  @Transactional
  public CustomIfoResponse updateCustomer(Custom custom, Long id) {
    Custom mainCustom = customRepository.getCustomById(id);
    Date date = new Date();
    custom.setUpdated(date.getTime());
    mainCustom.setFull_name(custom.getFull_name());
    mainCustom.setPhone(custom.getPhone());
    return new CustomIfoResponse(mainCustom);
  }

  @Transactional
  public void deleteCustomer(Long id) {
    Custom custom = customRepository.getCustomById(id);
    custom.setIs_active(false);
  }

}
