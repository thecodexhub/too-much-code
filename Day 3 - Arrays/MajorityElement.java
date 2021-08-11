// Given an array of size `n`, find the majority element. The majority element is the element that appears
// more than `floor of(n / 2)` times.
// You may assume that the array is non-empty and the majority element always exist in the array.

// [https://www.youtube.com/watch?v=AoX3BPWNnoE&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=16]

// Input: [7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5]
// Output: 5

// Moore's voting algorithm
// Time complexity: O(N), Space complexity: O(1)

public class MajorityElement {

  public static int majorityElement(int[] nums) {
    int element = 0, count = 0;

    for (int num : nums) {
      if (count == 0) {
        element = num;
      }

      if (num == element) {
        count += 1;
      } else {
        count -= 1;
      }
    }

    return element;
  }

  public static void main(String[] args) {
    int[] nums = { 7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5 };
    int result = majorityElement(nums);

    System.out.println(result);
  }
}
