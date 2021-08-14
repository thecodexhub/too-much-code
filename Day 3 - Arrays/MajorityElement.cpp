// For problem statement, see [MajorityElement.java]

#include <iostream>
#include <vector>
using namespace std;

class MajorityElement
{
public:
    int findMajorityElement(vector<int> &nums)
    {
        int element = 0, count = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (count == 0)
                element = nums[i];
            if (element == nums[i])
                count += 1;
            else
                count -= 1;
        }
    }
};