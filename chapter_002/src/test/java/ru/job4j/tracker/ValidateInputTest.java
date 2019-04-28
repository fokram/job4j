package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * //TODO add comments.
 *
 * @author r.markov
 * @version 1
 * @since 23.04.2017
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    private List<Integer> range = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", this.range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Please enter only menu point in number.\n")
                )
        );
    }

    @Test
    public void whenNoInMenuInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"99", "1"})
        );
        input.ask("Enter", this.range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Out of menu range.\n")
                )
        );
    }
}