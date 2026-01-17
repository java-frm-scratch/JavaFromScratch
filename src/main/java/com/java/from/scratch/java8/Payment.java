package com.java.from.scratch.java8;

public interface Payment {
    default void pay(){
        System.out.println("Pay using cash");
    }
}
