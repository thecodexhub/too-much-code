// Inversion count of an array indicates - how far (or close) the array is from being sorted.
// If the array is already sorted, the inversion count will be 0.
// If the array is sorted in reverse order, the inversion count will be maximum.
// Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] an i < j

// [https://www.youtube.com/watch?v=kQ1mJlwW-c0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=11]

// Input: [8, 4, 2, 1]
// Output: 6
// Explanation: Given array has 6 inversions.
// (8, 4), (8, 2), (8, 1), (4, 2), (4, 1), (2, 1)

// Time complexity: O(NlogN), Space complexity: O(N)

public class CountInversions {

  public int merge(int[] arr, int[] temp, int left, int mid, int right) {
    int i, j, k;
    int inv_count = 0;

    i = left;
    j = mid;
    k = left;

    while ((i <= mid - 1) && (j <= right)) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
        inv_count += mid - i;
      }
    }

    while (i <= mid - 1) {
      temp[k++] = arr[i++];
    }

    while (j <= right) {
      temp[k++] = arr[j++];
    }

    for (i = left; i <= right; i++) {
      arr[i] = temp[i];
    }

    return inv_count;
  }

  public int _mergeSort(int[] arr, int[] temp, int left, int right) {
    int mid, inv_count = 0;
    if (right > left) {
      mid = (left + right) / 2;

      inv_count += _mergeSort(arr, temp, left, mid);
      inv_count += _mergeSort(arr, temp, mid + 1, right);

      inv_count += merge(arr, temp, left, mid + 1, right);
    }

    return inv_count;
  }

  public int countInversions(int[] arr) {
    int[] temp = new int[arr.length];
    int result = _mergeSort(arr, temp, 0, arr.length - 1);
    return result;
  }
}
