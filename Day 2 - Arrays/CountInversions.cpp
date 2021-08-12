// For problem statement, see [CountInversions.java]

#include <iostream>
#include <vector>
using namespace std;

class CountInversions
{
    int merge(int arr[], int temp[], int left, int mid, int right)
    {
        int i, j, k;
        int inv = 0;

        i = left;
        j = mid;
        k = left;
        while ((i <= mid - 1) && (j <= right))
        {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
            {
                temp[k++] = arr[j++];
                inv += mid - i;
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inv;
    }

    int _mergeSort(int arr[], int temp[], int left, int right)
    {
        int inv_count = 0;
        int mid;

        if (right > left)
        {
            mid = (right + left) / 2;
            inv_count += _mergeSort(arr, temp, left, mid);
            inv_count += _mergeSort(arr, temp, mid + 1, right);

            inv_count += merge(arr, temp, left, mid + 1, right);
        }

        return inv_count;
    }

public:
    int countInversions(int nums[])
    {
        int n = sizeof(nums) / sizeof(nums[0]);
        int temp[n];
        int result = _mergeSort(nums, temp, 0, n - 1);
    }
};