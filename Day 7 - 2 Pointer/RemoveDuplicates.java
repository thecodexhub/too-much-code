// Given a sorted array [nums], remove the duplicates *in-place* such that each element
// appears only once and returns the new length.

// [https://www.youtube.com/watch?v=Fm_p9lJ4Z_8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=43]

// Input: [1,2,2,3]
// Output: 3

// Time complexity: O(N), Space complexity: O(1)

public class RemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i += 1;
        nums[i] = nums[j];
      }
    }

    return i + 1;
  }
}
