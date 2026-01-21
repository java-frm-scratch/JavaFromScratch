package com.java.from.scratch.SOLIDPrinciples.fifth_DependencyInversionPrinciple_DIP.solution;

public class WiringObjectsInDIContainer {


    /**
     * Now business logic is free from implementation details.
     * ✔ You can plug in any payment type without modifying PaymentService.
     *
     * @param args
     */
    public static void main(String[] args) {

        // DIP IN ACTION
        PaymentService p1 = new PaymentService(new CreditCardPayment());
        p1.makePayment(500);

        PaymentService p2 = new PaymentService(new UpiPayment());
        p2.makePayment(300);

        PaymentService p3 = new PaymentService(new WalletPayment());
        p3.makePayment(200);
    }
}
