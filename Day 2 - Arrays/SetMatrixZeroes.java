// Given m x n matrix, if an element is 0, set its entire row and column to 0

// [https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=8]

// Input:
// [
//  [0, 1, 2, 0]
//  [3, 4, 5, 2]
//  [1, 3, 1, 5]
// ]

// Output:
// [
//  [0, 0, 0, 0]
//  [0, 4, 5, 0]
//  [0, 3, 1, 0]
// ]

public class SetMatrixZeroes {

  public void setMatrixZeroes(int[][] matrix) {
    int col0 = 1, rows = matrix.length, cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) {
        col0 = 0;
      }
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = matrix[0][j] = 0;
        }
      }
    }

    for (int i = rows; i > 0; i--) {
      for (int j = cols; j > 0; j--) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
      if (col0 == 0) {
        matrix[i][0] = 0;
      }
    }
  }
}
