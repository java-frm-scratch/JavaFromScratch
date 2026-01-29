package com.java.from.scratch.interview.questions.fieldvsconstructorinjection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Engine {

    public Engine(){
        System.out.println("Engine constructor called");
    }
    public void start(){
        System.out.println("Engine started...");
    }
}
