// Given a set of N jobs where each job has a deadline and profit. Each job takes
// 1 unit of time and only one job can be scheduled at a time. The task is to find
// maximum profit and the number of jobs done.

// [https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=47]

// Input: N = 4, Jobs[] = [(1,4,20),(2,1,10),(3,1,40),(4,1,30)]
// Output: 2 60

// Time complexity: O(NlogN) + O(NxM), Space complexity: O(1)

import java.util.Arrays;

class Job {

  int id;
  int deadline;
  int profit;

  Job(int id, int deadline, int profit) {
    this.id = id;
    this.deadline = deadline;
    this.profit = profit;
  }
}

public class JobSequencing {

  public static int[] jobSequencing(Job arr[], int n) {
    Arrays.sort(arr, (a, b) -> b.profit - a.profit);
    int maxi = 0;
    for (int i = 0; i < n; i++) {
      maxi = Math.max(arr[i].deadline, maxi);
    }

    int[] result = new int[maxi + 1];
    for (int i = 1; i <= maxi; i++) {
      result[i] = -1;
    }

    int countJobs = 0, countProfit = 0;

    for (int i = 0; i < n; i++) {
      for (int j = arr[i].deadline; j > 0; j--) {
        if (result[j] == -1) {
          result[j] = arr[j].id; // result[j] = i
          countJobs++;
          countProfit += arr[j].profit;
          break;
        }
      }
    }

    int[] ans = new int[2];
    ans[0] = countJobs;
    ans[1] = countProfit;
    return ans;
  }
}
