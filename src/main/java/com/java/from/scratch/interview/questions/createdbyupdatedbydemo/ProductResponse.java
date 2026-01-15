package com.java.from.scratch.interview.questions.createdbyupdatedbydemo;

import java.time.LocalDateTime;

public record ProductResponse(
        Long id,
        String name,
        double price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}