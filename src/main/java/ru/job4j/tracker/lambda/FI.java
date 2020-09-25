package ru.job4j.tracker.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        String[] atts = {
                "one", "four", "three"
        };

        Comparator<String> cmpDescSize = (left, right) -> {
            Integer.compare(right.length(), left.length());
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        Arrays.sort(atts, cmpDescSize);

        for (String attachment: atts
             ) {
            System.out.println(attachment);
        }
    }

}

