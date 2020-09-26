package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {

    public Student duplicate(Student student1) {
        student1.setSurname(student1.getSurname() +  "duplicate");
        return student1;
    }

    public Map<String, Student> getStdMap(List<Student> students) {
        Map<String, Student> stdMap = students.stream().collect(Collectors
                .toMap(student -> student.getSurname(),
                        student -> student,
                        (student, student2) -> duplicate(student)));
        return stdMap;
    }
}
