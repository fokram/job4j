package ru.job4j.coffeemaker;

import java.util.Arrays;

public class CoffeeMaker {
    public static int[] getChange(int cash, int bill) {
        if (bill >= cash) {
            return null;
        }
        int[] coins = new int[] {10,5,2,1};
        int[] changes = new int[500];
        int i = 0;
        while (cash - bill > 0) {
            for (int coin:coins) {
                if (coin <= cash - bill) {
                    changes[i++] = coin;
                    cash = cash - coin;
                    break;
                }
            }
        }
        changes = Arrays.copyOf(changes, i);
        return changes;
    }
}
