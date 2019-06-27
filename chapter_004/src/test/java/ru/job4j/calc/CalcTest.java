package ru.job4j.calc;

import org.junit.Test;
import ru.job4j.calc.Calc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalcTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Calc function = new Calc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuaqFunctionThenQuadResults() {
        Calc function = new Calc();
        List<Double> result = function.diapason(3, 5, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(9D, 16D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        Calc function = new Calc();
        List<Double> result = function.diapason(100, 101, x -> Math.log10(x));
        List<Double> expected = Arrays.asList(2D);
        assertThat(result, is(expected));
    }
}
