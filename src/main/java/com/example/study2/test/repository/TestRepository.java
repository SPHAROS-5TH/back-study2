package com.example.study2.test.repository;

import com.example.study2.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Product, Long> {
}
