package com.java.from.scratch.SOLIDPrinciples.fifth_DependencyInversionPrinciple_DIP.solution;

/**
 * PaymentService no longer creates objects.
 * 👉 Now it depends only on the interface, not on specific payment types.
 */
public class PaymentService {

    private final PaymentStrategy paymentStrategy;

    // Constructor Injection (DIP)
    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
