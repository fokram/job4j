package ru.job4j.calculator;
/**
*Calculator Класс калькулятор
*@author rMarkov
*@since 16.03.2019
*@version 1
*/
public class Calculator {
  /**
   * Method add
   * @param first слагаемое
   * @param second слагаемое
   * @return double сумма
   */
  public double add(double first, double second) {
    return first + second;
  }
  /**
   * Method subtract
   * @param first уменьшаемое
   * @param second вычитаемое
   * @return double разница
   */
  public double subtract(double first, double second) {
    return first - second;
  }
  /**
   * Method div
   * @param first делимое
   * @param second делитель
   * @return double частное
   */
  public double div(double first, double second) {
    return first / second;
  }
  /**
   * Method multiple
   * @param first множитель
   * @param second множитель
   * @return double произведение
   */
  public double multiple(double first, double second) {
    return first * second;
  }
}