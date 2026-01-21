package com.java.from.scratch.SOLIDPrinciples.fourth_InterfaceSegregationPrinciple.problem;


public interface INotificationService {
    void sendEmail(String message);// sending email notification is what supported currently
    void sendSms(String message);
    void sendWhatsapp(String message);
    void sendPush(String message);
}
