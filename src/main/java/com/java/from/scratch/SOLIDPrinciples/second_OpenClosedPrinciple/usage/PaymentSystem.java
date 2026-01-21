package com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.usage;

import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.CreditCardPayment;
import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.PaymentService;
import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.WalletPayment;

public class PaymentSystem {



        public static void main(String[] args) {

            PaymentService service1 = new PaymentService(new CreditCardPayment());
            service1.makePayment(2500);

           /* PaymentService service2 = new PaymentService(new UpiPayment());
            service2.makePayment(1000);*/

            PaymentService service3 = new PaymentService(new WalletPayment());
            service3.makePayment(500);
        }
    }


