package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public record ProductEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String name,
        double price,

        @Column(name = "created_at", nullable = false, updatable = false)
        LocalDateTime createdAt,

        @Column(name = "updated_at", insertable = false)
        LocalDateTime updatedAt
) {
    // Custom constructor for JPA
    public ProductEntity withId(Long id) {
        return new ProductEntity(id, name(), price(), createdAt(), updatedAt());
    }
}
