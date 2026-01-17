package com.java.from.scratch.java8;

public class Employee implements PersonFunctionalInterface{
    @Override
    public int getAge() {
        return 15;
    }

   /* @Override
    public void printName() {
        //PersonFunctionalInterface.super.printName();
        System.out.println("this is my own implementation of default method inside Employee implemntation class");
    }*/

    // static methods cannnot be overridden
   /* @Override
    public String info() {
        return "Hello";
    }*/


}
