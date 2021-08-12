// Given an array of integers [nums] and an integer [target],
// are there elements a, b, c and d in the nums such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.

// [https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=21]

// Example: Given array nums = {1, 0, -1, 0, -2, 2} and target = 0
// A solution set is: [
//  [-1, 0, 0, 1].
//  [-2, -1, 1, 2],
//  [-2, 0, 0, 2]
// ]

// Time complexity: O(N3), Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length <= 0) return result;

    Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int front = j + 1;
        int back = n - 1;
        int target_two = target - nums[i] - nums[j];

        while (front < back) {
          int two_sum = nums[front] + nums[back];
          if (two_sum > target_two) back--; 
          else if (two_sum < target_two) front++; 
          else {
            List<Integer> quad = new ArrayList<Integer>();
            quad.add(nums[i]);
            quad.add(nums[j]);
            quad.add(nums[front]);
            quad.add(nums[back]);
            result.add(quad);

            while (front < back && nums[front] == quad.get(2)) front++;
            while (front < back && nums[back] == quad.get(3)) back--;
          }
        }

        while (j + 1 < n && nums[j + 1] == nums[j]) j++;
      }
      while (i + 1 < n && nums[i + 1] == nums[i]) i++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 4, 3, 3, 4, 4, 2, 1, 2, 1, 1 };
    List<List<Integer>> result = fourSum(nums, 9);

    for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.get(i).size(); j++) {
        System.out.print(result.get(i).get(j) + "  ");
      }
      System.out.println();
    }
  }
}
