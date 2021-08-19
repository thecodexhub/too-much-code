// Given a binary array, find the maximum number of consecutive 1s in this array.

// [https://www.youtube.com/watch?v=Mo33MjjMlyA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=44]

// Input: [1,1,0,1,1,1]
// Output: 3

// Time complexity: O(N), Space complexity: O(1)

public class MaxConsecutiveOnes {

  public int findMaxConsecutiveOnes(int[] nums) {
    int maximum = 0, count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) count += 1; 
      else count = 0;
      maximum = Math.max(count, maximum);
    }
    return maximum;
  }
}
