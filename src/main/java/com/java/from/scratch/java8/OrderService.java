package com.java.from.scratch.java8;

public class OrderService implements Payment, OnlinePayment{

  /*  @Override
    public void pay() {
        Payment.super.pay();
        OnlinePayment.super.pay();// you can combine both as well

    }*/

    @Override
    public void pay(){
       //Payment.super.pay();
        OnlinePayment.super.pay();
    }
}
