package com.java.from.scratch.interview.questions.fieldvsconstructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Car {

    //@Autowired
    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    /*public Car(){
        System.out.println("Car constructor called");
    }*/

    public void drive(){
        engine.start();
        System.out.println("Car is driving...");
    }


}
