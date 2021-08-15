// For problem statement, see [LongestConsecutive.java]

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class LargestSubarrayZeroSum
{
public:
    int findMaxLength(vector<int> &nums)
    {
        unordered_map<int, int> mpp;
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            sum += nums[i];
            if (sum == 0)
                maxLength = i + 1;
            else if (mpp.find(sum) != mpp.end())
                maxLength = max(maxLength, i - mpp[sum]);
            else
                mpp[sum] = i;
        }
        return maxLength;
    }
};
