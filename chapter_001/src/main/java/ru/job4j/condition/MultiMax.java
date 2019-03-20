package ru.job4j.condition;

public class MultiMax {
  public int max(int first, int second, int third) {
    //    int result = first;
    return (
              ((first > second)
              ? first
                : second)
              > third)
            ?
            ((first > second)
                    ? first : second)
            : third;
  }
}