// Given arrival and departure times of all the trains that reach a railway station.
// Find minimum number of platforms needed so that no train is kept waiting.

// [https://www.youtube.com/watch?v=dxVcMDI7vyI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=46]

// Input: N = 6, arr[] = [0900, 0940, 0950, 1100, 1500, 1800]
// dep[] = [0910, 1200, 1120, 1130, 1900, 2000]
// Output: 3

// Time complexity: O(2NlogN) + O(2N), Space complexity: O(1)

import java.util.Arrays;

public class MinimumPlatforms {

  public static int findPlatforms(int[] arr, int[] dep, int n) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int plat_needed = 1, result = 1;
    int i = 1, j = 0;

    while (i < n && j < n) {
      if (arr[i] < dep[j]) {
        plat_needed++;
        i++;
      } else if (arr[i] > dep[j]) {
        plat_needed--;
        j++;
      }

      result = Math.max(plat_needed, result);
    }

    return result;
  }
}
