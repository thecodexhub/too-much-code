// Implement pow(x, n) which calculates x raised to the power n.

// [https://www.youtube.com/watch?v=l0YC3876qxg&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=15]

// Input: x = 2.00000, n = 10
// Output: 1024.00000

// Time complexity: O(log₂N), Space complexity: O(1)

public class CalculatePower {

  public double calculatePower(double x, int n) {
    double ans = 1.0;
    long nn = n;
    if (nn < 0) nn = (-1) * nn;

    while (nn > 0) {
      if (nn % 2 != 0) {
        ans = ans * x;
        nn = nn - 1;
      } else {
        x = x * x;
        nn = nn / 2;
      }
    }

    if (n < 0) ans = (double) (1.0) / (double) (ans);
    return ans;
  }
}
