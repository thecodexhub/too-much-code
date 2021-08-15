// For problem statement, see [TwoSum.java]

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class TwoSum
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        vector<int> res;
        unordered_map<int, int> mpp;
        for (int i = 0; i < nums.size(); i++)
        {
            if (mpp.find(target - nums[i]) != mpp.end())
            {
                res.push_back(mpp[target - nums[i]]);
                res.push_back(i);
                return res;
            }
            mpp[nums[i]] = i;
        }
    }
};