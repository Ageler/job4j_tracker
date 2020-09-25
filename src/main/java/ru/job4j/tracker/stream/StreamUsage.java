package ru.job4j.tracker.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, -4, -8, 0);
        List<Integer> filtNum = numbers.stream().filter(number -> number >= 0)
                .collect(Collectors.toList());
        filtNum.forEach(System.out::println);
    }

}
