// Given an array of integers [nums] and an integer [target], return the indices
// of the two numbers such that they add upto target.
// You may assume that each input would have exactly one solution, and you may not use the same
// element twice. You can return the answer in any order.

// [https://www.youtube.com/watch?v=dRUpbt8vHpo&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=2]

// Input: nums = [2, 7, 11, 15], target = 9
// Output: [0, 1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]

// Time complexity: O(N), Space complexity: O(N)

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        result[1] = i;
        result[0] = map.get(target - nums[i]);
        return result;
      } else {
        map.put(nums[i], i);
      }
    }

    return result;
  }
}
