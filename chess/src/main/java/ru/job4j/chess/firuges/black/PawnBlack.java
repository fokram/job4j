package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.ImposibleMoveException;

import static java.lang.Math.abs;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnBlack implements Figure {
    private final Cell position;

    public PawnBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int increment;
        Cell[] steps = new Cell[0];
        //определяем направление движения по доске(вперед или назад относительно координат
        if (dest.y > source.y) {
            increment = 1;
        } else {
            increment = -1;
        }
        //заполнеяем путь двежиения
        if (source.x == dest.x && (abs(dest.y - source.y) == 1 || source.y == 6 && dest.y == 4 || source.y == 1 && dest.y == 3)) {
            steps = new Cell[abs(dest.y - source.y)];
            for (int i = 0; i < steps.length; i++) {
                steps[i] = Cell.findByXY(source.x, source.y + (i + 1) * increment);
            }
        }
//        else {
//            throw new ImposibleMoveException("Так ходить нельзя");
//        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnBlack(dest);
    }
}
