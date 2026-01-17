package com.java.from.scratch.java8;

@FunctionalInterface
public interface PersonFunctionalInterface extends AgeProvider{

   // void getAddress();

    //String getPersonName();// compile time error Multiple non-overriding abstract methods found in PersonFunctionalInterface@PersonFunctionalInterface.java#L3

    // option to be overridden
    default boolean isAdult(){
        return getAge() >18;
    }

    default void printName(){
        System.out.println("My name is javafrom scratch.....");
    }



    // static method
    static String info(){
        return "this interface belong to human being";
    }

    String toString();// overriding Object class method is perfectly allowed
}
