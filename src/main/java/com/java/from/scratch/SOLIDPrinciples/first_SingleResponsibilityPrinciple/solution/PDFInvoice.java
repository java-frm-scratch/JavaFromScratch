package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution;

public class PDFInvoice implements IinvoiceService{
    @Override
    public void createInvoice() {
        System.out.println("creating an invoice in PDF format");
        // all logic of creating invoice should go here
    }
}
