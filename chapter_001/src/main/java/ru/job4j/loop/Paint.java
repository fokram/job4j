package ru.job4j.loop;
/**
 * Paint Класс рисование
 * @author RomanM
 * @version 1
 * @since 23.03.2019
*/
public class Paint {

  /**
   * piramid метод рисования пирамиды целиком
   * @param h - высота пирамиды
   * @author RomanM
   * @version 1
   * @since 23.03.2019
   */
  public String piramid(int h) {
    StringBuilder screen = new StringBuilder();
    String ln = System.lineSeparator();
    for (int y = 1; y <= h; y++) {
      for (int x = 1; x <= 2 * h - 1; x++) {
        if (x >= h - y + 1 && x <= h + y - 1) {
          screen.append("^");
        } else {
          screen.append(" ");
        }
      }
      // добавляем перевод на новую строку.
      screen.append(ln);
    }
    return screen.toString();
  }

  /**
   * rightTrl метод рисования правой стороны пирамиды
   * @param h - высота пирамиды
   * @author RomanM
   * @version 1
   * @since 24.03.2019
   */
  public String rightTrl(int h) {
    StringBuilder screen = new StringBuilder();
    String ln = System.lineSeparator();
    for (int y = 1; y <= h; y++) {
      for (int x = 1; x <= h; x++) {
        if (x <= y) {
          screen.append("^");
        } else {
          screen.append(" ");
        }
      }
      // добавляем перевод на новую строку.
      screen.append(ln);
    }
    return screen.toString();
  }

  /**
   * leftTrl метод рисования левой стороны пирамиды
   * @param h - высота пирамиды
   * @author RomanM
   * @version 1
   * @since 24.03.2019
   */
  public String leftTrl(int h) {
    StringBuilder screen = new StringBuilder();
    String ln = System.lineSeparator();
    for (int y = 1; y <= h; y++) {
      for (int x = 1; x <= h; x++) {
        if (x > h - y) {
          screen.append("^");
        } else {
          screen.append(" ");
        }
      }
      // добавляем перевод на новую строку.
      screen.append(ln);
    }
    return screen.toString();
  }
}