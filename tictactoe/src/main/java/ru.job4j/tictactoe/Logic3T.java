package ru.job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean isWiner(Predicate<Figure3T> predicate) {
        boolean result = false;
        // проверим все горизонтали и вертикали
        for (int i = 0; i < table.length; i++) {
            result = this.fillBy(predicate, 0, i, 1, 0)
                    || this.fillBy(predicate, i, 0, 0, 1);
            if (result) {
                break;
            }
        }

        //проверили горизонтали/вертикали, а теперь проверим обе диагонали
        if (!result) {
            result = this.fillBy(predicate, 0, 0, 1, 1)
                    || this.fillBy(predicate, this.table.length - 1, 0, -1, 1);
        }
        return result;
    }
    public boolean isWinnerX() {
        return isWiner(p -> p.hasMarkX());
    }

    public boolean isWinnerO() {
        return isWiner(p -> p.hasMarkO());
    }

    public boolean hasGap() {
        return true;
    }
}
