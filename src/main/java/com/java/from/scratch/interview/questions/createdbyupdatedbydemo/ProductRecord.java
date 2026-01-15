package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import java.time.LocalDateTime;



public record ProductRecord(
        Long id,
        String name,
        String description,
        Double price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
