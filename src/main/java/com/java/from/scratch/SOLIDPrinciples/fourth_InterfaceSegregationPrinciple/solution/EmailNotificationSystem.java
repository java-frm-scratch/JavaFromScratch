package com.java.from.scratch.SOLIDPrinciples.fourth_InterfaceSegregationPrinciple.solution;

/**
 *  Benefits of ISP (in real-world systems)
 * ✔ 1. No more unnecessary methods
 * Your classes remain simple and clean.
 * ✔ 2. No system crash risk
 * (Remember earlier UnsupportedOperationException?)
 * ✔ 3. High flexibility
 * You can mix and match notification types.
 * ✔ 4. Better maintainability
 * Changing the WhatsApp API doesn’t affect email code.
 * ✔ 5. Classes depend only on what they use
 * This improves:
 *
 * Testability
 * Readability
 * Extensibility
 */
public class EmailNotificationSystem implements IEmailNotification{


    @Override
    public void sendEmail() {
        System.out.println("Sending email ");
        // add email sending logic here
    }
}
