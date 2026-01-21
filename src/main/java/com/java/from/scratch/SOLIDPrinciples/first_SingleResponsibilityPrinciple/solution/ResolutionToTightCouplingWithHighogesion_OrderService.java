package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.solution;

/**


 High Cohesion - each class is doing their own job
 orderService - creatingorder
 email service sendin email
 invoice service, will create invoice


 Loose Coupling
 if PDF logic chnages , only invoice serice will change
 if database chnages , then only change is needed in IorderRepository

 so we achieved class should have only 1 reason to chanege
 */
public class ResolutionToTightCouplingWithHighogesion_OrderService {
    private final IorderRepository iorderRepository;// database saving purpose
    private final IemailService iemailService;// for sending email to customer , saying that your order is successful
    private final IinvoiceService iinvoiceService;// to generate the invoice in different formats like pdf, text

    public ResolutionToTightCouplingWithHighogesion_OrderService(IorderRepository iorderRepository,
    IemailService iemailService, IinvoiceService iinvoiceService
    ){
        this.iorderRepository = iorderRepository;
        this.iemailService= iemailService;
        this.iinvoiceService = iinvoiceService;
    }

    public void palceOrder(){
        iorderRepository.placeOrder();
        iemailService.sendEmail();
        iinvoiceService.createInvoice();
    }
}
