package com.java.from.test;

import com.java.from.scratch.java8.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {


        /*CompletableFuture future = CompletableFuture.supplyAsync(s->{


            performValidation(new Validation(false,"XYZ"));
                });

        //future.AllOf(){

        }*/


        List<EmployeeData> list = List.of(

                new EmployeeData("amol","HR","Male",10000),
                new EmployeeData("raj","Technical","Male",50000),
                new EmployeeData("radha","Technical","female",80000),
                new EmployeeData("seeta","finance","female",90000)

        );

        //Collectors.groupingBy()
        // 50000
        list.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                .collect(Collectors.toList());
        list.stream().
                collect(Collectors.groupingBy( e-> e.getGender()));

        // System

        Map<String, Map<String, Optional<EmployeeData>>> result =
                list.stream()
                        .collect(Collectors.groupingBy(
                                EmployeeData::getDepartment,
                                Collectors.groupingBy(
                                        EmployeeData::getGender,
                                        Collectors.maxBy(
                                                Comparator.comparing(EmployeeData::getSalary)
                                        )
                                )
                        ));

        // Print result
        result.forEach((dept, genderMap) -> {
            System.out.println("Department: " + dept);
            genderMap.forEach((gender, empOpt) ->
                    empOpt.ifPresent(emp ->
                            System.out.println("  " + gender + " → " +
                                    emp.getName() + " : " + emp.getSalary())
                    )
            );
        });

        //EmployeeData employeeData = new EmployeeData();
        //employeeData= null;


    }

    private static boolean performValidation(Validation validation){
        // validation logic goes here
        // by calling third party api ..
        return true;
    }
}

@Data
@AllArgsConstructor
class Validation{
    boolean isValidCustomer;
    String customerName;
}

/**
 * group employees by department
 * then by gender
 * in each sub group
 * find highest salary
 */
@Data
@AllArgsConstructor
class EmployeeData{
    private  String name;
    String department;
    String gender;
    double salary;
}