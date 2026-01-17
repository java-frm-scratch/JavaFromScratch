package com.java.from.scratch.java8;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        PersonFunctionalInterface functionalInterface = () ->  20;


        int age = functionalInterface.getAge();
        System.out.println(age);


        PersonFunctionalInterface myFirstFunctionalInterface = () ->  20;
        int age2 =myFirstFunctionalInterface.getAge();
        System.out.println(age2);


        // functional interface to show with implemting class
        // with static and default methods
        PersonFunctionalInterface personFunctionalInterface = new Employee();
        int age3 = personFunctionalInterface.getAge();
        System.out.println(age3);
        boolean isAdult = personFunctionalInterface.isAdult();
        System.out.println(isAdult);
        personFunctionalInterface.printName();
        System.out.println(PersonFunctionalInterface.info());


        // how to call static methods
        System.out.println(PersonFunctionalInterface.info());


        int max = AgeProvider.MAX;
        System.out.println("Max age:"+max);





    }
}
