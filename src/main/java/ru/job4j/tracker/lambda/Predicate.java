package ru.job4j.tracker.lambda;

public interface Predicate<T> {
    boolean test(T t);
}
