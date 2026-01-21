package com.java.from.scratch.SOLIDPrinciples.second_OpenClosedPrinciple.problem;
/**



 Real‑World Example (Non‑Programming)
 Imagine an Electrical Switch Board.

 When you want to add a new device (fan, heater, AC), you don’t break the wall to change internal wiring.
 You just add a new plug or device.

 Switch board = closed for modification
 New plug/device = extension
 Software should work the same way.

 example of same order placement
 initially system supports only credit card
 now we want to add
 UPI, WALLET, COD facility

 if existing class need to modify everythime, you violates the open closed principle

 */
public class BADExampleViolatingOCP_PaymentService {

    /**
     every time a new payment method added , you modify same class
     code becoems large bug prone and hard to debug and violates OCP

     * @param paymentType
     */
    public void processPayment(String paymentType){

        if(paymentType.equalsIgnoreCase("CREDIT")){
            System.out.println("Processing credit card payment");
        }
        else if(paymentType.equalsIgnoreCase("UPI")){
            System.out.println("Processing UPI payment");
        }
        else if(paymentType.equalsIgnoreCase("WALLET")){
            System.out.println("Processing wallet payment");
        }
        // cash on delivery
        else if(paymentType.equalsIgnoreCase("COD")){
            System.out.println("Processing cash on delivery payment ....");
        }
        // tomorrow new method, then we end up with modifying the class again
    }
}
