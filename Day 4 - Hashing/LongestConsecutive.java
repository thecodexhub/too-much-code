// Given an unsorted array of integers, find the length of longest consecutive sequence.

// [https://www.youtube.com/watch?v=qgizvmgeyUM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=22]

// Input: [100, 4, 200, 1, 2, 3]
// Output: 4
// Explanation: The longest consecutive element sequence is [1, 2, 3, 4], length = 4

// Time complexity: O(3N) --> O(N), Space complexity: O(N)

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

  public int longestConsecutive(int[] nums) {
    Set<Integer> hashSet = new HashSet<Integer>();
    for (int num : nums) {
      hashSet.add(num);
    }

    int longestStreak = 0;

    for (int num : nums) {
      if (!hashSet.contains(num - 1)) {
        int number = num;
        int currentStreak = 0;
        while (hashSet.contains(number + 1)) {
          number += 1;
          currentStreak += 1;
        }
        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }
    return longestStreak;
  }
}
