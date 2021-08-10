// Given a non-negative number [numRows], generate the first numsRows of Pascal's triangle.

// [https://www.youtube.com/watch?v=6FLvhQjZqvM&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=9]

// Input: 5
// Output:
// [
//  [1],
//  [1, 1],
//  [1, 2, 1],
//  [1, 3, 3, 1],
//  [1, 4, 6, 4, 1]
// ]

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> row, pre = null;

    for (int i = 0; i < numRows; i++) {
      row = new ArrayList<Integer>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(pre.get(j - 1) + pre.get(j));
        }
      }
      pre = row;
      result.add(row);
    }

    return result;
  }
}
