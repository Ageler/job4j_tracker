package ru.job4j.tracker.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public List<Integer> matrix2list(Integer[][] matrix) {
        List<Integer> matList = Arrays.stream(matrix)
                .flatMap(integers -> Stream.of(integers))
                .collect(Collectors.toList());
        return matList;
    }
}
