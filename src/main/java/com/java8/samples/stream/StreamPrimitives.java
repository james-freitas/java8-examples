package com.java8.samples.stream;

import java.util.Arrays;
import java.util.List;

public class StreamPrimitives {

    public static void main(String[] args) {

        sumIntegersUsingStream();

        sumDoublesUsingStream();

    }

    private static void sumDoublesUsingStream() {
        List<Double> decimals = Arrays.asList(4.1, 3.2, 5.8);
        double sum = decimals.stream()
                .mapToDouble(d -> d)
                .sum();
        System.out.println(sum);
    }

    private static void sumIntegersUsingStream() {
        List<Integer> numbers = Arrays.asList(5, 10, 15);

        int sum = numbers.stream()
                .mapToInt(i -> i)
                .sum();

        System.out.println(sum);
    }

}
