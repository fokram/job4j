package ru.job4j.array;

public class BubbleSort {

  public int[] sort(int[] array) {
    if (array.length != 1) {
      boolean isDone = false;
      int unSortedLength = array.length;
      while (!isDone) {
        isDone = true;
        int i = 1;
        while (i < unSortedLength) {
          if (array[i] < array[i - 1]) {
            isDone = false;
            int tmp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = tmp;
          }
          i++;
        }
        unSortedLength--;
      }
    }
    return array;
  }
}