package ru.job4j.array;

public class MergeSort {

  public static int[] merge(int[] array1, int[] array2) {
    int len = array1.length + array2.length;
    int[] array = new int[len];
    int n = 0;
    int i = 0;
    int j = 0;
    while (i < array1.length || j < array2.length) {
      if (j >= array2.length) {
        array[n] = array1[i];
        n++;
        i++;
      } else if (i >= array1.length) {
        array[n] = array1[i];
        n++;
        i++;
      } else if (array1[i] > array2[j]) {
        array[n] = array2[j];
        n++;
        j++;
      } else {
        array[n] = array1[i];
        n++;
        i++;
      }
    }
    return array;
  }
}