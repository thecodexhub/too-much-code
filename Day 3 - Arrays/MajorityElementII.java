// Given an array of size `n`, find the majority elemens that appear more than `floor of(n / 3)` times.
// Note: The algorithm should run in linear time complexity and O(1) space.

// [https://www.youtube.com/watch?v=yDbkQd9t2ig&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=17]

// Input: [1, 1, 1, 3, 3, 2, 2, 2]
// Output: [1, 2]

// Boyer-Moore majority voting algorithm
// Time complexity: O(N) + O(N) = O(N), Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

  public static List<Integer> findMajorityElements(int[] nums) {
    int element1 = -1, element2 = -1, count1 = 0, count2 = 0;

    for (int num : nums) {
      if (num == element1) {
        count1 += 1;
      } else if (num == element2) {
        count2 += 1;
      } else if (count1 == 0) {
        element1 = num;
        count1 = 1;
      } else if (count2 == 0) {
        element2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }

    List<Integer> result = new ArrayList<Integer>();
    count1 = 0;
    count2 = 0;

    for (int num : nums) {
      if (num == element1) {
        count1 += 1;
      } else if (num == element2) {
        count2 += 1;
      }
    }

    if (count1 > Math.floor(nums.length / 3)) result.add(element1);
    if (count2 > Math.floor(nums.length / 3)) result.add(element2);

    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };
    List<Integer> result = findMajorityElements(nums);

    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }
    System.out.println();
  }
}
