package ru.job4j.loop;
/**
  *Board Класс шахматная доска
  *@author RomanM
 *@version 1
  *@since 23.03.2019
*/
public class Board {
  public String paint(int width, int height) {
    StringBuilder screen = new StringBuilder();
    String ln = System.lineSeparator();
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // условие проверки, что писать пробел или X
        // Выше в задании мы определили закономерность, когда нужно проставлять X
        if (y % 2 == 0 && x % 2 == 0 || (y % 2 != 0 && x % 2 != 0)) {
          screen.append("X");
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