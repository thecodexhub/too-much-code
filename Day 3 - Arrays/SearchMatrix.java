// Write an efficient algorithm that searches for a value in a m x n matrix
// The matrix has following properties:
// 1. Integers in each row are sorted from left to right
// 2. The first integer of each row is greater than the last integer of the previous row

// [https://www.youtube.com/watch?v=ZYpYur0znng&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=14]

// Input:
// matrix =  [
//  [1, 3, 5, 7]
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
// ]
// target = 3

// Output: true

// Time complexity: O(log₂(n * m)), Space complexity: O(1)

public class SearchMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    int lo = 0;
    int hi = (n * m) - 1;

    while (lo <= hi) {
      int mid = (lo + (hi - lo)) / 2;
      if (matrix[mid / m][mid % m] == target) {
        return true;
      } else if (matrix[mid / m][mid % m] > target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return false;
  }
}
