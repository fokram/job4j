package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint Класс рисование
 * @author RomanM
 * @version 1
 * @since 23.03.2019
*/
public class Paint {

  /**
   * loopBy метод рисования пирамиды целиком
   * @param height - высота пирамиды
   * @param widht - высота пирамиды
   * @param predict - условие выражения
   * @author RomanM
   * @since 24.03.2019
   */
  private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
    StringBuilder screen = new StringBuilder();
    for (int row = 0; row != height; row++) {
      for (int column = 0; column != widht; column++) {
        if (predict.test(row, column)) {
          screen.append("^");
        } else {
          screen.append(" ");
        }
      }
      screen.append(System.lineSeparator());
    }
    return screen.toString();
  }
  /**
   * piramid метод рисования пирамиды целиком
   * @param height - высота пирамиды
   * @author RomanM
   * @since 23.03.2019
   */
  public String piramid(int height) {
    return this.loopBy(
            height,
            2 * height - 1,
            (row, column) -> row >= height - column - 1 && row + height - 1 >= column
    );
  }

  /**
   * rightTrl метод рисования правой стороны пирамиды
   * @param height - высота пирамиды
   * @author RomanM
   * @since 24.03.2019
   */
  public String rightTrl(int height) {
    return this.loopBy(height, height, (row, column) -> row >= column);
  }

  /**
   * leftTrl метод рисования левой стороны пирамиды
   * @param height - высота пирамиды
   * @author RomanM
   * @since 24.03.2019
   */
  public String leftTrl(int height) {
    return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
  }
}