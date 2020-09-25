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
        Diapazon function = new Diapazon();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void testwhenQuadraticFunctionThenQuadraticResults() {
        Diapazon function = new Diapazon();
        List<Double> result = function.diapason(1, 4, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void testwhenIndicativeFunctionThenIndicativeResults() {
        Diapazon function = new Diapazon();
        List<Double> result = function.diapason(1, 5, x -> Math.pow(5, x));
        List<Double> expected = Arrays.asList(5D, 25D, 125D, 625D);
        assertThat(result, is(expected));
    }
}