package com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution;

public class CODPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("when the parcel will reach out to your home, then pay "+amount+" to the delivery agent");
    }
}
