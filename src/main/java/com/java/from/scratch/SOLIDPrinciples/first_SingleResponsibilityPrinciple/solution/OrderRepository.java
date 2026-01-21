package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution;

public class OrderRepository implements IorderRepository {
    @Override
    public void placeOrder() {
        System.out.println("Saving order to database...");
        // Actual database operations would go here
    }
}