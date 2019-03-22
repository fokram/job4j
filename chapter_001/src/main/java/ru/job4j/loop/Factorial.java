package ru.job4j.loop;
/**
  *Calculator Класс counter подсчет для цикла
  *@author rMarkov
  *@since 22.03.2019
  *@version 1
*/
public class Factorial {
  public int calc(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result = result * i;
    }
    return result;
  }
}