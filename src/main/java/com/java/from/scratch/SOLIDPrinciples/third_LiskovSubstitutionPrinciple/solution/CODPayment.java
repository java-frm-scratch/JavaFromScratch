package com.java.from.scratch.SOLIDPrinciples.third_LiskovSubstitutionPrinciple.solution;

import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.PaymentStrategy;

/**
 * Why is this good?
 *
 * It does not break the parent contract.
 * It gives a valid payment behavior.
 * It works flawlessly wherever PaymentStrategy is used.
 */
public class CODPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Order placed. Pay " + amount + " in cash upon delivery.");
    }

}
