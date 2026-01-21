package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution;

public class EmailService implements IemailService {
    @Override
    public void sendEmail() {
        System.out.println("Sending order confirmation email...");
        // Actual email sending logic would go here
    }
}
