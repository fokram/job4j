package ru.job4j.condition;
/**
 *condition Класс определения расстояния между двуми точками на плоскости
 *@author rMarkov
 *@since 17.03.2019
 *@version 1
 */

public class Max {
  public int max(int left, int right) {
    return right > left ? right : left;
  }
}