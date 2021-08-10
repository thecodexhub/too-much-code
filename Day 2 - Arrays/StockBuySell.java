// Say you have an array for which the i-th element is the price of the given stock on day i.

// If you were permitted only to complete at most one transaction (ie, buy one and sell one share
// of the stock), design an algorithm to find the maximum profit.

// Note that you cannot sell a stock before you buy one.

// [https://www.youtube.com/watch?v=eMSfBgbiEjk&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=12]

// Input : [7, 1, 5, 3, 6, 4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 5

// Time complexity: O(N), Space complexity: O(1)

public class StockBuySell {

  public static int findProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int profit = 0;

    for (int price : prices) {
      min = Math.min(min, price);
      profit = Math.max(profit, price - min);
    }

    return profit;
  }

  public static void main(String[] args) {
    int[] prices = { 7, 1, 5, 3, 6, 4 };
    int profit = findProfit(prices);
    System.out.println(profit);
  }
}
