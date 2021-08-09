// Merge two sorted Arrays without extra space

// [https://www.youtube.com/watch?v=hVl2b3bLzBw&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=4]

// Input: left[] = {1, 4, 7, 8, 10}, right[] = {2, 3, 9}
// Output: left[] = {1, 2, 3, 4, 7}, right[] = {8, 9, 10}

import java.util.Arrays;
import java.util.Scanner;

class MergeArrays {

  public static void mergeTwoArrays(int[] left, int[] right) {
    // Traverse through the left array starting from 0 to n - 1
    // if left[i] > right[0], then swap the numbers and sort the right array

    for (int i = 0; i < left.length; i++) {
      if (left[i] > right[0]) {
        int temp = left[i];
        left[i] = right[0];
        right[0] = temp;

        Arrays.sort(right);
      }
    }
  }

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter length for left array: ");

    int leftLength = userInput.nextInt();
    int[] left = new int[leftLength];
    for (int i = 0; i < leftLength; i++) {
      left[i] = userInput.nextInt();
    }

    System.out.print("Enter length for right array: ");

    int rightLength = userInput.nextInt();
    int[] right = new int[rightLength];
    for (int i = 0; i < rightLength; i++) {
      right[i] = userInput.nextInt();
    }

    Arrays.sort(left);
    Arrays.sort(right);

    mergeTwoArrays(left, right);

    System.out.print("After merged left: ");
    for (int i : left) {
      System.out.print(i + " ");
    }

    System.out.println();

    System.out.print("After merged right: ");
    for (int i : right) {
      System.out.print(i + " ");
    }

    userInput.close();
  }
}
