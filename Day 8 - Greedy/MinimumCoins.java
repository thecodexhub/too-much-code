// Given a value V, if we want to make a change for V Rs, an we have infinite supply of
// { 1, 2, 5, 10, 20, 50, 100, 500, 1000 } coins then what is the minimum number of coins
// required to make the change?

// [https://www.youtube.com/watch?v=mVg9CfJvayM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48]

// Input: V = 121
// Output: 3

// Time complexity: O(V), Space complexity: O(1)

import java.util.ArrayList;

public class MinimumCoins {

  public static int findCoins(int V) {
    ArrayList<Integer> coins = new ArrayList<>();

    int[] deno = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
    int n = deno.length;

    for (int i = n - 1; i >= 0; i++) {
      while (V >= deno[i]) {
        V -= deno[i];
        coins.add(deno[i]);
      }
    }

    return coins.size();
  }
}
