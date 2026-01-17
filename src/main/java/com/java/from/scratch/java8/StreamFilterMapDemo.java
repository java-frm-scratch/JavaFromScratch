package com.java.from.scratch.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFilterMapDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        /**
         * you have a list ,
         * find the element graeater than 2
         * and then multiply element by 10
         * and then dind the first element
         */

        Optional<Integer> first = numbers.stream()
                .filter(number -> number > 2)
                .map(number -> number * 10)
                .findFirst();
        System.out.println(first.get());

    }
}
