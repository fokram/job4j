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
    public boolean isWiner(char xOrO) {
        boolean result = false;
        // проверим все горизонтали и вертикали
        for (int i = 0; i < table.length; i++) {
            if (xOrO == 'X') {
                result = this.fillBy(Figure3T::hasMarkX, 0, i, 1, 0)
                        || this.fillBy(Figure3T::hasMarkX, i, 0, 0, 1);
            } else if (xOrO == 'O') {
                result = this.fillBy(Figure3T::hasMarkO, 0, i, 1, 0)
                        || this.fillBy(Figure3T::hasMarkO, i, 0, 0, 1);
            }
            if (result) {
                break;
            }
        }

        //проверили горизонтали/вертикали, а теперь проверим обе диагонали
        if (!result && xOrO == 'X') {
            result = this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                    || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
        } else if (!result && xOrO == 'O') {
            result = this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                    || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
        }
        return result;
    }
    public boolean isWinnerX() {
        return isWiner('X');
    }

    public boolean isWinnerO() {
        return isWiner('O');
    }

    public boolean hasGap() {
        return true;
    }
}
