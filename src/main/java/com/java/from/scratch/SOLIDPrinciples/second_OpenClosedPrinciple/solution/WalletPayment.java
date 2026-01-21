package com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution;

/**
 * open for extension
 */
public class WalletPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount +"Using Wallet");
    }
}
