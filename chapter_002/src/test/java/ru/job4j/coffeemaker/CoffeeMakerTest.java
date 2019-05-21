package ru.job4j.coffeemaker;

import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class CoffeeMakerTest {
    @Test
    public void whenCashFiftyBillThirtyFive() {

        CoffeeMaker coffee = new CoffeeMaker();
        int[] changes = CoffeeMaker.getChange(50, 35);
        int[] expected = new int[] {10, 5};
        assertThat(changes, is(expected));
    }
    @Test
    public void whenCashFiftyTwoBillThirtyFive() {

        CoffeeMaker coffee = new CoffeeMaker();
        int[] changes = CoffeeMaker.getChange(52, 35);
        int[] expected = new int[] {10, 5, 2};
        assertThat(changes, is(expected));
    }
}