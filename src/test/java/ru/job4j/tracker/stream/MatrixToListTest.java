package ru.job4j.tracker.stream;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrixToListTest extends TestCase {

    public void testMatrix2list() {
        MatrixToList m2list = new MatrixToList();
        Integer[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> rsl = m2list.matrix2list(mat);
        List<Integer> exp = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(rsl, exp);
    }
}