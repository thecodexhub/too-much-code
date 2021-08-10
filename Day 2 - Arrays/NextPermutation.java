// Implement *next permutation* which re-arranges number into the lexicographically next greater
// permutation of the numbers.

// if such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
// sorted in ascending order).

// The replacement must be in place and use only constant extra memory.

// [https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=10]

// Example:
// 1, 2, 3 --> 1, 3, 2
// 3, 2, 1 --> 1, 2, 3
// 1, 1, 5 --> 1, 5, 1

public class NextPermutation {

  public void nextPermutation(int[] A) {
    if (A == null || A.length <= 1) return;

    int i = A.length - 2;
    while (A[i] > A[i + 1]) i--;

    if (i >= 0) {
      int j = A.length - 1;
      while (A[j] < A[i]) j--;
      swap(A, i, j);
    }

    reverse(A, i + 1, A.length - 1);
  }

  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void reverse(int[] arr, int start, int end) {
    while (start < end) swap(arr, start++, end--);
  }
}
