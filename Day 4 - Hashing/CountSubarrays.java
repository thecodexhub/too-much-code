// Count the number of subarrays having a given XOR
// Given an array of integers A[], and a number m, count the number of subarrays
// having XOR of their elements as B.

// [https://www.youtube.com/watch?v=lO9R5CaGRPY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=24]

// Input: A[] = {4, 2, 2, 6, 4}, m = 6
// Output: 4
// Explanation: The subarray having XOR of their elements as 6 are
// {4, 2}, {4, 2, 2, 6, 4}, {2, 2, 6} and {6}

// Time complexity: O(NlogN), Space complexity: O(N)

import java.util.HashMap;

public class CountSubarrays {

  public int countSubarrays(int[] A, int B) {
    HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    int xorr = 0;
    int cnt = 0;
    int n = A.length;
    for (int i = 0; i < n; i++) {
      xorr = xorr ^ A[i];
      if (freq.get(xorr ^ B) != null) cnt += freq.get(xorr ^ B);
      if (xorr == B) cnt += 1;
      if (freq.get(xorr) != null) {
        freq.put(xorr, freq.get(xorr) + 1);
      } else {
        freq.put(xorr, 1);
      }
    }
    return cnt;
  }
}
