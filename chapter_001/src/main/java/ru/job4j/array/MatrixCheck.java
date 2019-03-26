package ru.job4j.array;

public class MatrixCheck {
  public boolean mono(boolean[][] data) {
    int height = data.length;
    if (height > 1) {
      for (int i = 1; i < height; i++) {
        if (data[i][i] != data[i - 1][i - 1]
            || data[i - 1][height - i] != data[i][height - i - 1]) {
          return false;
        }
      }
    }
    return true;
  }
}

//                {true, true, true, true},
//                {false, true, true, false},
//                {true, true, true, false},
//                {true, false, true, true}