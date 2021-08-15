// For problem statement, see [FourSum.java]

#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

class FourSum
{
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target)
    {
        vector<vector<int>> result;
        if (nums.empty())
            return result;

        sort(nums.begin(), nums.end());

        int n = nums.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int front = j + 1;
                int back = n - 1;
                int target_two = target - nums[front] - nums[back];
                while (front < back)
                {
                    int two_sum = nums[front] + nums[back];
                    if (two_sum < target_two)
                        front++;
                    else if (two_sum > target_two)
                        back--;
                    else
                    {
                        vector<int> quad(4, 0);
                        quad.push_back(i);
                        quad.push_back(j);
                        quad.push_back(front);
                        quad.push_back(back);
                        result.push_back(quad);

                        while (front < back && nums[front] == quad[2])
                            front++;
                        while (front < back && nums[back] == quad[3])
                            back--;
                    }
                }
                while (j + 1 < n && nums[j + 1] == nums[j])
                    j++;
            }
            while (i + 1 < n && nums[i + 1] == nums[i])
                i++;
        }
        return result;
    }
};
