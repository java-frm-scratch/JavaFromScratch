package com.java.from.scratch.javaLatestFeatures.first_sealed_class;

public class SealedDemo {

    static void main() {
        Parent parent = new Son();
        System.out.println("Son is using parent wealth"+parent.wealth());


        GrandSon grandSon = new Stranger1();
        System.out.println("Stranger1 is using grandSon wealth"+grandSon.wealth());

        Parent parent1 = new Daughter();
        System.out.println("Daughter is using parent wealth"+parent1.wealth());
    }
}
