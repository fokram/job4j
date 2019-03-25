package ru.job4j.array;

public class BubbleSort {

  public int[] sort(int[] array) {
    if (array.length != 1) {
      boolean isDone = false;
      while (!isDone) {
        isDone = true;
        for (int i = 1; i < array.length; i++) {
          if (array[i] < array[i - 1]) {
            isDone = false;
            int tmp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = tmp;
          }
        }
      }
    }
    return array;
  }
}