package ru.job4j.tracker.lambda;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapazonTest extends TestCase {

    @Test
    public void testwhenLinearFunctionThenLinearResults() {
        Function<Double, Double> func = x -> 2 * x + 1;
       List<Double> result = new ArrayList<>();
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
}