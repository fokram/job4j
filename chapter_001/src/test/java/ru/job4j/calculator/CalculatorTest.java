package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Roman.Markov
 * @version 1
 * @since 16.03.2019
 */
public class CalculatorTest {
    /**
     * Test calculate values
     */

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        double result = calc.subtract(1, 1);
        double expected = 0;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoMultileThreeThenSix() {
        Calculator calc = new Calculator();
        double result = calc.multiple(2, 3);
        double expected = 6;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoDevideFourThenHalf() {
        Calculator calc = new Calculator();
        double result = calc.div(2, 4);
        double expected = .5;
        assertThat(result, is(expected));
    }
}