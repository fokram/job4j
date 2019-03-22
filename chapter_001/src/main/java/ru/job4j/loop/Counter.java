package ru.job4j.loop;
/**
  *Calculator Класс counter подсчет для цикла
  *@author rMarkov
  *@since 22.03.2019
  *@version 1
*/
public class Counter {
  public int add(int start, int finish) {
    int sum = 0;
    for (int i = start; i <= finish; i++) {
      if (i % 2 == 0) {
        sum = sum + i;
      }
    }
    return sum;
  }
}