package com.example.demo.repository;

import com.example.demo.entity.Custom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomRepository extends CrudRepository <Custom, Long> {
 Custom getCustomById(Long id);
 Custom getCustomByEmail(String email);
}
