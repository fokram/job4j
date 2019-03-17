package ru.job4j.condition;
/**
 *condition Класс определения расстояния между двуми точками на плоскости
 *@author rMarkov
 *@since 17.03.2019
 *@version 1
 */

public class Point {
  /**
   * Method distance
   * @param x1 координата Х первой точки
   * @param y1 координата Y первой точки
   * @param x2 координата Х второй точки
   * @param y2 координата Y второй точки
   * @return искомая дистанция
   */
  public double distance(int x1, int y1, int x2, int y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2)) + Math.sqrt(Math.pow(y2 - y1, 2));
  }
}