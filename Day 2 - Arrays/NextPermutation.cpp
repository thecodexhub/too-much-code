// For problem statement, see [NextPermutation.java]

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class NextPermutation
{
public:
    void nextPermutation(vector<int> &nums)
    {
        int i = nums.size() - 2;
        while (nums[i] > nums[i + 1])
            i--;

        if (i > 0)
        {
            int j = nums.size() - 1;
            while (nums[j] < nums[i])
                j--;
            swap(nums[i], nums[j]);
        }

        reverse(nums.begin() + i + 1, nums.end());
    }
};
