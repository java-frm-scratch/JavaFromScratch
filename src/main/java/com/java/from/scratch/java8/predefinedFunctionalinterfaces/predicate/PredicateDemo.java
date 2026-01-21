package com.java.from.scratch.java8.predefinedFunctionalinterfaces.predicate;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PredicateDemo {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Ram", 24, 5000, "IT"),
                new Employee("Shyam", 40, 10000, "HR"),
                new Employee("Mahesh", 30, 90000, "IT"),
                new Employee("Suresh", 50, 500000, "Finance")

        );

        /*Predicate<Employee> itDeptEmployee =
                (employee -> employee.getDepartment().equalsIgnoreCase("IT"));
        Consumer consumer;

        employees.stream()
                .filter(itDeptEmployee)
                .forEach(System.out::println);*/


/*Predicate<Employee> salaryPredicate
        = (employee -> employee.getSalary() > 60000);
employees.stream()
        .filter(salaryPredicate)
        .forEach(System.out::println);*/


        Predicate<Employee> itDeptPredicate
                = (employee -> employee.getDepartment().equalsIgnoreCase("IT"));
        Predicate<Employee> salaryPredicate
                = (employee -> employee.getSalary() > 60000);

        Predicate<Employee> deptAndSalaryPredicate
                = itDeptPredicate.and(salaryPredicate);

        employees.stream()
                .filter(deptAndSalaryPredicate)
                .forEach(System.out::println);

        employees.stream()
                .filter(employee -> employee.getSalary()>60000 && employee.getDepartment().equalsIgnoreCase("IT"))
                .forEach(System.out::println);


    }

}

@Data
class Employee {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
}
