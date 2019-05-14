package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static java.lang.Math.abs;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int incrementX;
        int incrementY;
        Cell[] steps = new Cell[0];
        //определяем направление движения по доске(вперед или назад относительно оси координат Y
        if (dest.y > source.y) {
            incrementY = 1;
        } else {
            incrementY = -1;
        }
        //определяем направление движения по доске(вперед или назад относительно оси координат X
        if (dest.x > source.x) {
            incrementX = 1;
        } else {
            incrementX = -1;
        }
        //проверяем логику движения фигуры и заполнеяем путь двежиения, если логика ок
        if (abs(source.x - dest.x) == abs(source.y - dest.y)) {
            steps = new Cell[abs(dest.y - source.y)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByXY(source.x + (i + 1) * incrementX, source.y + (i + 1) * incrementY);
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
