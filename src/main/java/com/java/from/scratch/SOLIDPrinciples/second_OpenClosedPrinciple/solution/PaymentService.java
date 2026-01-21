package com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution;

/**
 * No matter how many payment methods you add, this class never changes.
 */
public class PaymentService {
    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount){
        paymentStrategy.pay(amount);
    }
}
