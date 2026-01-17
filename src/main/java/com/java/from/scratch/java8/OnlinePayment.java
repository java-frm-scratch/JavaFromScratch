package com.java.from.scratch.java8;

public interface OnlinePayment {
    default void pay(){
        System.out.println("Pay using online ");
    }
}
