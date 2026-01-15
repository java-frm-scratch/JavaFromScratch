package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
