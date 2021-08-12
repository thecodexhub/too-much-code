// Given an array with both positive and negative integers.
// The task is to compute the length of the longest subarray having the sum 0.

// [https://www.youtube.com/watch?v=xmguZ6GbatA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=23]

// Input: [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5
// Explanation: The largest subarray with 0 sum is -2 2 8 1 7

// Time complexity: O(NlogN), Space complexity: O(N)

import java.util.HashMap;

public class LargestSubarrayZeroSum {

  public int findMaxLength(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int maximum = 0;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (sum == 0) maximum = i + 1;

      if (map.get(sum) != null) {
        maximum = Math.max(maximum, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }

    return maximum;
  }
}
