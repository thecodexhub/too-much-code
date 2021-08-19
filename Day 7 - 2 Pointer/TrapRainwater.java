// Given n non-negative integers, representing an elevation map where thw width of
// each bar is 1, compute how much water it can trap after the raining.

// [https://www.youtube.com/watch?v=m18Hntz4go8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=42]

// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6

// Time complexity: O(N), Space complexity: O(1)

public class TrapRainwater {

  public int trap(int[] height) {
    int n = height.length;
    int left = 0, right = n - 1;
    int maxLeft = 0, maxRight = 0;
    int result = 0;

    while (left <= right) {
      if (height[left] <= height[right]) {
        if (height[left] >= maxLeft) maxLeft = height[left]; 
        else result += maxLeft - height[left];
        left++;
      } else {
        if (height[right] >= maxRight) maxRight = height[right]; 
        else result += maxRight - height[right];
        right--;
      }
    }

    return result;
  }
}
