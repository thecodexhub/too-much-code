// You are given n x n 2D matrix representing an image.
// Rotate the image by 90 degrees (clockwise).

// [https://www.youtube.com/watch?v=Y72QeX0Efxw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=13]

// Input:
// [
//  [1, 2, 3]
//  [4, 5, 6]
//  [7, 8, 9]
// ]

// Output:
// [
//  [7, 4, 1]
//  [8, 5, 2]
//  [9, 6, 3]
// ]

// Time complexity: O(N^2), Space complexity: O(1)

public class RotateMatrix {

  public void rotateMatrix(int[][] m) {
    // Transpose the matrix
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
      }
    }

    // Reverse every row
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m.length / 2; j++) {
        int temp = m[i][j];
        m[i][j] = m[i][m.length - 1 - j];
        m[i][m.length - 1 - j] = temp;
      }
    }
  }
}
