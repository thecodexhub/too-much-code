// Sort an array of 0’s 1’s 2’s without using extra space or sorting algo.

// Dutch National Flag Algorithm [Time complexity: O(N), Space Complxity: O(1)]
// [https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=3]

// Input: [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]

public class SortColors {

  public void sortColors(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    int mid = 0;
    int temp;

    while (mid <= hi) {
      switch (nums[mid]) {
        case 0:
          {
            temp = nums[mid];
            nums[mid] = nums[lo];
            nums[lo] = temp;
            mid++;
            lo++;
            break;
          }
        case 1:
          {
            mid++;
            break;
          }
        case 2:
          {
            temp = nums[mid];
            nums[mid] = nums[hi];
            nums[hi] = temp;
            hi--;
            break;
          }
      }
    }
  }
}
