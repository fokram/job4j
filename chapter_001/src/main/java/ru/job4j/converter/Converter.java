package ru.job4j.converter;
/**
*Calculator Класс конвертр валют
*@author rMarkov
*@since 17.03.2019
*@version 1
*/
public class Converter {

  /**
   * Конвертируем рубли в евро.
   * @param value рубли.
   * @return Евро.
   */
  public int rubleToEuro(int value) {
    return value / 70;
  }

  /**
   * Конвертируем рубли в доллары.
   * @param value рубли.
   * @return Доллары
   */
  public int rubleToDollar(int value) {
    return value / 60;
  }
  /**
   * Конвертируем евро в рубли.
   * @param value евро.
   * @return Евро.
   */
  public int euroToRuble(int value) {
    return value * 70;
  }

  /**
   * Конвертируем доллары в рубли.
   * @param value доллары.
   * @return Доллары
   */
  public int dollarToRuble(int value) {
    return value * 60;
  }
}