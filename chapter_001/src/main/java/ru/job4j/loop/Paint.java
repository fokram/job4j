package ru.job4j.loop;
/**
  *Paint Класс рисование
  *@author RomanM
 *@version 1
  *@since 23.03.2019
*/
public class Paint {
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
}