package ru.job4j.tracker.stream;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class StudentMapTest extends TestCase {
    StudentMap stdM = new StudentMap();

    public void testDuplicate() {
        List<Student> students = Arrays.asList(
                new Student(50, "Sobolev"),
                new Student(60, "Sobolev")
        );
    }
}