package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Schema(description = "Product entity representing a product in the system")
@Entity
//@Data
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The database generated product ID")
    private Long id;

    @Schema(description = "Name of the product", example = "Laptop")
    private String name;
    @Schema(description = "Price of the product", example = "999.99")
    private double price;

    @Schema(description = "Date when the product was created", hidden = true)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Schema(description = "Date when the product was last updated", hidden = true)
    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
