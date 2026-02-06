package com.java.from.scratch.javaLatestFeatures.first_sealed_class;

public sealed class Parent permits Son,Daughter{

    public String wealth(){
        return "wealth";
    }
}
