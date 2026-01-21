package com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution;

import com.java.from.scratch.java8.Payment;

/**
 * this is open for extension
 */
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid"+amount+": Using credit card");
    }
}
