package com.java.from.scratch.SOLIDPrinciples.fifth_DependencyInversionPrinciple_DIP.solution;


public class UpiPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

