package com.java.from.scratch.SOLIDPrinciples.fifth_DependencyInversionPrinciple_DIP.solution;

/**
 * Business logic depends on PaymentStrategy (abstraction)
 * NOT concrete classes
 */
public interface PaymentStrategy {
    void pay(double amount);
}

