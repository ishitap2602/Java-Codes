package com.test;

import java.util.*;
import java.util.stream.*;
import java.util.Optional;

public class StreamBasicsDemo {

    public static void main(String[] args) {

        // ---------- 1) Filter even numbers ----------
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> evens = nums.stream()
            .filter(n -> n % 2 == 0)
            .toList(); // Java 16+
            // .collect(Collectors.toList()); // Java 8 alternative
        System.out.println("Evens: " + evens);

        // ---------- 2) Map to uppercase ----------
        List<String> names = List.of("ishita", "pavan");
        List<String> upper = names.stream()
            .map(String::toUpperCase)
            .toList(); // Java 16+
            // .collect(Collectors.toList()); // Java 8 alternative
        System.out.println("Upper: " + upper);

        // ---------- 3) Sorted (natural order) ----------
        List<String> sorted = names.stream()
            .sorted()
            .toList(); // Java 16+
            // .collect(Collectors.toList()); // Java 8 alternative
        System.out.println("Sorted: " + sorted);

        // ---------- 4) Distinct ----------
        List<Integer> distinctNums = List.of(1, 2, 2, 3, 3).stream()
            .distinct()
            .toList(); // Java 16+
            // .collect(Collectors.toList()); // Java 8 alternative
        System.out.println("Distinct nums: " + distinctNums);

        // ---------- 5) Collect after filter ----------
        List<String> result = names.stream()
            .filter(n -> n.length() > 4)
            .collect(Collectors.toList()); // Works on all versions
        System.out.println("Names with length > 4: " + result);

        // ---------- 6) Reduce to sum ----------
        int sum = List.of(1, 2, 3).stream()
            .reduce(0, Integer::sum); // start at 0
        System.out.println("Sum via reduce: " + sum);

        // ---------- 7) Match/find/count ----------
        boolean hasLongName = names.stream()
            .anyMatch(n -> n.length() > 10);
        Optional<String> first = names.stream()
            .findFirst();
        long count = names.stream()
            .count();

        System.out.println("Has long name (>10)? " + hasLongName);
        System.out.println("First name: " + first.orElse("(none)"));
        System.out.println("Count of names: " + count);

        // ---------- 8) Primitive streams ----------
        int total = IntStream.of(1, 2, 3).sum();
        double avg = DoubleStream.of(1.0, 2.0)
            .average()
            .orElse(0.0);

        System.out.println("IntStream total: " + total);
        System.out.println("DoubleStream average: " + avg);

        // ---------- Bonus: Chain multiple operations ----------
        List<String> chained = names.stream()
            .map(String::toUpperCase)
            .filter(s -> s.startsWith("P"))
            .sorted()
            .toList(); // Java 16+
            // .collect(Collectors.toList()); // Java 8 alternative
        System.out.println("Chained (UPPER, starts with P, sorted): " + chained);
    }
}


