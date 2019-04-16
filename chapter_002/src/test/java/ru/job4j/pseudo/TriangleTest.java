package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author ROman Markov
 * @version $Id$
 * @since 16.04.2019
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("   +\n")
                                .append("  +++\n")
                                .append(" +++++\n")
                                .append("+++++++")
                                .toString()
                )
        );
    }
}