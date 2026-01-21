package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.usage;

import com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution.ResolutionToTightCouplingWithHighogesion_OrderService;
import com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution.TextInvoice;

import com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution.*;

public class Main {
    public static void main(String[] args) {
        // 1. Create instances of all dependencies
        IorderRepository orderRepository = new OrderRepository();
        IemailService emailService = new EmailService();
        IinvoiceService invoiceService = new TextInvoice(); // or PDFInvoice if you have one

        // 2. Create the service with all its dependencies
        ResolutionToTightCouplingWithHighogesion_OrderService orderService =
                new ResolutionToTightCouplingWithHighogesion_OrderService(
                        orderRepository,
                        emailService,
                        invoiceService
                );

        // 3. Use the service
        System.out.println("Placing order...");
        orderService.palceOrder();
        System.out.println("Order placed successfully!");


    }
}
