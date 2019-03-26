package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
  public static String[] remove(String[] array) {
    int countDuplicateElement  = 0;
    int length = array.length;
    int i = 0;
    while (i < length - countDuplicateElement) {
      int j = i + 1;
      while (j < length - countDuplicateElement) {
        if (array[i].equals(array[j])) {
          String tmp = array[j];
          array[j] = array[length - countDuplicateElement - 1];
          array[length - countDuplicateElement - 1] = tmp;
          countDuplicateElement++;
        } else {
          j++;
        }
      }
      i++;
    }
    return Arrays.copyOf(array, array.length - countDuplicateElement);
  }
}