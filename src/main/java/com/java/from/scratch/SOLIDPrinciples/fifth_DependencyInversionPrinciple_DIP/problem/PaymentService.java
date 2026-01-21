package com.java.from.scratch.SOLIDPrinciples.fifth_DependencyInversionPrinciple_DIP.problem;


import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.CreditCardPayment;
import com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.solution.WalletPayment;

/**
 * Let’s stay in the same example: Payment Service.
 * Assume your business logic directly creates objects:
 *
 * What’s wrong?
 *
 * High-level class PaymentService depends on a low-level class CreditCardPayment.
 * If tomorrow you want UPI or Wallet, you must modify business logic.
 * Not testable → cannot mock dependencies.
 * Violates both OCP and DIP.
 *
 * This is tightly coupled and difficult to extend.
 *
 */
public class PaymentService {

    private CreditCardPayment creditCardPayment = new CreditCardPayment();
    private WalletPayment walletPayment = new WalletPayment();

}

