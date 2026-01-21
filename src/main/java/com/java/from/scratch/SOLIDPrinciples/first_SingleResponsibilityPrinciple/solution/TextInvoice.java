package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution;

public class TextInvoice implements IinvoiceService{
    @Override
    public void createInvoice() {
        System.out.println("Creating invoice in Text format");
    }
}
