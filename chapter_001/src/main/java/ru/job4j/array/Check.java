package ru.job4j.array;

public class Check {
  public boolean mono(boolean[] data) {
    boolean result = (data.length == 1 ? true : false);
    for (int i = 1; i != data.length; i++) {
      if (data[i] != data[i - 1]) {
        return result;
      }
    }
    // если успешно вышел из цилка - значит не нашел различий
    result = true;
    return result;
  }
}