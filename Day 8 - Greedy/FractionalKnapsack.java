// Given weight and value of N items, we need to put them in a knapsack with
// capacity W to get maximum total value in the knapsack.

// [https://www.youtube.com/watch?v=F_DDzYnxO14&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49]

// Input: N = 3, W = 5, values[] = [60,100,120], weight[] = [10,20,30]
// Output: 240.0

// Time complexity: O(NlogN) + O(N), Space complexity: O(1)

import java.util.Arrays;
import java.util.Comparator;

class Item {

  int value, weight;

  Item(int x, int y) {
    this.value = x;
    this.weight = y;
  }
}

class ItemComparator implements Comparator<Item> {

  @Override
  public int compare(Item o1, Item o2) {
    double r1 = (double) (o1.value) / (double) (o1.weight);
    double r2 = (double) (o2.value) / (double) (o2.weight);
    if (r1 < r2) return 1; else if (r1 > r2) return -1; else return 0;
  }
}

public class FractionalKnapsack {

  public static double fractionalKnapsack(int W, Item arr[], int n) {
    Arrays.sort(arr, new ItemComparator());

    int currentWeight = 0;
    double finalvalue = 0.0;

    for (int i = 0; i < n; i++) {
      if (currentWeight + arr[i].weight <= W) {
        currentWeight += arr[i].weight;
        finalvalue += arr[i].value;
      } else {
        int remain = W - currentWeight;
        finalvalue +=
          ((double) (arr[i].value) / (double) (arr[i].weight)) *
          (double) remain;
        break;
      }
    }

    return finalvalue;
  }
}
