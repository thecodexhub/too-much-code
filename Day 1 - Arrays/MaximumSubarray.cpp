// For problem statement, see [RepeatMissingNumber.java]

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

class MaximumSubarray
{
public:
    int maximumSubarray(vector<int> &nums)
    {
        int max = INT_MIN;
        int sum = 0;

        for (int i = 0; i < nums.size(); i++)
        {
            sum += nums[i];
            max = std::max(sum, max);
            if (sum < 0)
                sum = 0;
        }

        return max;
    }
};
