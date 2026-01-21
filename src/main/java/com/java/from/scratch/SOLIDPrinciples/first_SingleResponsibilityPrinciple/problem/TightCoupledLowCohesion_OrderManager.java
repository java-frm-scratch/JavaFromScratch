package com.java.from.scratch.SOLIDPrinciples.first_SingleResponsibilityPrinciple.problem;

/**

 Low cohesion class does many unrelated jobs at once

tight coupling if one service changes , this class must be changed


 */
public class TightCoupledLowCohesion_OrderManager
{


    public void createOrder(){

    }
    public void saveOrderTodatabase(){

    }

    public void sendEmailNotification(){

    }
    public void generateInvoicePDF(){

    }

    public void palceOrder(){

    }



}
