package com.java.from.scratch.interview.questions.fieldvsconstructorinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
/**

 1) in application context, only metadata will be laoded first
 2) then singleton objects will get created
 3) then post processors will run
 4) then it returns the context
 5) then we can get the bean from the context
 6) then we can use the bean
 7) then finally application will get terminated


 */
public class Tester {
    public static void main(String[] args) {


        // Start Spring container (annotation processing happens here)
        ConfigurableApplicationContext context =
                SpringApplication.run(Tester.class, args);
        System.out.println("Empty container created ...no beans yet");
       //Engine engine = (Engine) context.getBean("engine");
        boolean present = context.containsBean("car");
        boolean isEngineBeanPresent = context.containsBean("engine");
        System.out.println(present);
        // Get bean from Spring
        Car car = context.getBean(Car.class);

        // Test
        car.drive();
    }
}
