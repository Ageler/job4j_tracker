package ru.job4j.tracker.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> matList = Arrays.stream(matrix)
            .flatMap(integers -> Stream.of(integers))
            .collect(Collectors.toList());

    public static void main(String[] args) {
        MatrixToList m = new MatrixToList();
        m.matList.forEach(System.out::println);
    }
}
