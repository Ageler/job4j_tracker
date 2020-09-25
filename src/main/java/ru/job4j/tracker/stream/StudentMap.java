package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    List<Student> students = new ArrayList<>();
    Map<String, Student> stdMap = students.stream().distinct().collect(Collectors
            .toMap(student -> student.getSurname(),
                    student -> student));
}
