package com.java.from.scratch.SOLIDPrinciples.third_LiskovSubstitutionPrinciple.problem;

import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.PaymentStrategy;

public class BADExampleViolatingLSP_CODPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        throw new UnsupportedOperationException("COD cannot process online payments");
    }
}
