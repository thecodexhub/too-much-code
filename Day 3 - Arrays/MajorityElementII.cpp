// For problem statement, see [MajorityElementII.java]

#include <iostream>
#include <vector>
using namespace std;

class MajorityElementII
{
public:
    vector<int> findMajorityElement(vector<int> &nums)
    {
        int element1 = -1, element2 = -1, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] == element1)
                count1 += 1;
            else if (nums[i] == element2)
                count2 += 1;
            else if (count1 == 0)
            {
                element1 = nums[i];
                count1 = 1;
            }
            else if (count2 == 0)
            {
                element2 = nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        vector<int> ans;
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums[i] == element1)
                count1 += 1;
            else if (nums[i] == element2)
                count2 += 1;
        }

        if (count1 > nums.size() / 3)
            ans.push_back(element1);
        if (count2 > nums.size() / 3)
            ans.push_back(element2);

        return ans;
    }
};