package com.java.from.scratch.SOLIDPrinciples.fourth_InterfaceSegregationPrinciple.problem;

/**
 * What’s wrong?
 *
 * You are forced to implement methods you don’t need.
 * You end up throwing UnsupportedOperationException.
 * If someone calls sendPush() → your app crashes.
 * The interface is fat, bloated, not reusable.
 * Any change in the interface forces all implementations to change → violates OCP too.
 */
public class EmailNotification implements INotificationService{
    @Override
    public void sendEmail(String message) {
        System.out.println("sending email ....");
    }

    @Override
    public void sendSms(String message) {
        throw new UnsupportedOperationException("SMS not supported");
    }

    @Override
    public void sendWhatsapp(String message) {
        throw  new UnsupportedOperationException("WhatsApp not supported");
    }

    @Override
    public void sendPush(String message) {
        throw new UnsupportedOperationException("Push not supported");
    }
}
