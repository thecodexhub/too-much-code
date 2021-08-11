// Given an array [nums], we call (i, j) as reverse pair if i < j and nums[i] > 2 * nums[j]
// You need to return the number of important reverse pairs in the given array.

// [https://www.youtube.com/watch?v=S6rsAlj_iB4&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=19]

// Input: [1, 3, 2, 3, 1]
// Output: 2

// Time complexity: O(NlogN) + O(N) --> For merge + O(N) --> For counting (in worst case), 
// Space complexity: O(N)

import java.util.ArrayList;

public class ReversePairs {

  public int merge(int[] nums, int low, int mid, int high) {
    int count = 0;
    int j = mid + 1;
    for (int i = low; i <= mid; i++) {
      while (j <= high && nums[i] > (2 * (long) nums[j])) {
        j++;
      }
      count += j - (mid + 1);
    }

    ArrayList<Integer> temp = new ArrayList<>();
    int left = low, right = mid + 1;
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp.add(nums[left++]);
      } else {
        temp.add(nums[right++]);
      }
    }

    if (left <= mid) {
      temp.add(nums[left++]);
    }

    if (right <= high) {
      temp.add(nums[right++]);
    }

    for (int i = low; i <= high; i++) {
      nums[i] = temp.get(i - low);
    }

    return count;
  }

  public int mergeSort(int[] nums, int low, int high) {
    if (low >= high) return 0;
    int mid = (low + (high - low)) / 2;
    int inv = mergeSort(nums, low, mid);
    inv += mergeSort(nums, mid + 1, high);
    inv += merge(nums, low, mid, high);

    return inv;
  }

  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }
}
