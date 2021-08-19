// Given an array [nums] of n integers, are there elements a, b, c in [nums]
// such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// [https://www.youtube.com/watch?v=onLoX6Nhvmg&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=41]

// Input: nums = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, -1, 2], [-1, 0, 1]]

// Time complexity: O(N^2) and Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length < 3) return result;

    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int lo = i + 1;
      int hi = n - 1;
      int two_sum = nums[lo] + nums[hi];
      int target = -nums[i];

      while (lo < hi) {
        if (two_sum > target) hi--; 
        else if (two_sum < target) lo++; 
        else {
          List<Integer> triplet = new ArrayList<Integer>();
          triplet.add(nums[i]);
          triplet.add(nums[lo]);
          triplet.add(nums[hi]);
          result.add(triplet);

          while (lo < hi && nums[lo] == triplet.get(1)) lo++;
          while (lo < hi && nums[hi] == triplet.get(2)) hi--;
        }
      }

      while (i + 1 < n && nums[i + 1] == nums[i]) i++;
    }

    return result;
  }
}
