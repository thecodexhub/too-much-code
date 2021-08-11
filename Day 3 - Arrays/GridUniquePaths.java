//  A robot is located at the top corner of a m x n grid.
// The robot can only move either down or right at any point of time. The robot is trying to reach
// the bottom-right corner of the grid.

// How many possible unique grids are there?

// [https://www.youtube.com/watch?v=t_f0nwwdg5o&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=19]

// For a 4 x 3 grid, possible unique grids are = 3

// Time complexity: O(m - 1) or O(n - 1) and Space complexity: O(1)

public class GridUniquePaths {

  // public int countPaths(int i, int j, int n, int m) {}

  // Recursive approach [Time complexity and Space complexity are exponential]
  /**
  int countPaths(int i, int j, int n, int m) {
    if (i == (n - 1) && j == (m - 1)) return 1;
    if (i >= n || j >= m) return 0; else return (
      countPaths(i + 1, j, n, m) + countPaths(i, j + 1, n, m)
    );
  }
  */

  // Dynamic Programming [Time complexity and Space complexity = O(N x M)]
  int countPaths(int i, int j, int n, int m, int[][] dp) {
    if (i == (n - 1) && j == (m - 1)) return 1;
    if (i >= n || j >= m) return 0;

    if (dp[i][j] != -1) return dp[i][j]; else return (
      dp[i][j] = countPaths(i + 1, j, n, m, dp) + countPaths(i, j + 1, n, m, dp)
    );
  }

  // Most optimal solution
  public int uniquePaths(int m, int n) {
    int N = m + n - 2;
    int r = Math.min(n - 1, m - 1); // nCr = nCn-r
    double res = 1;

    for (int i = 1; i <= r; i++) {
      res = res * (N - r + i) / i;
    }

    return (int) res;
  }
}
