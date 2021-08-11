// For problem statement, see [RepeatMissingNumber.java]

#include <iostream>
#include <vector>
using namespace std;

class RepeatMissingNumber
{
public:
    void repeatMissingNumber(vector<int> &nums)
    {
        int xor1 = 0;

        for (int i = 0; i < nums.size(); i++)
            xor1 = xor1 ^ nums[i];

        for (int i = 0; i < nums.size(); i++)
            xor1 = xor1 ^ i;

        int set_bit = xor1 & ~(xor1 - 1);

        int x = 0, y = 0;

        for (int i = 0; i < nums.size(); i++)
        {
            if ((nums[i] & set_bit) != 0)
                x = x ^ nums[i];
            else
                y = y ^ nums[i];
        }

        for (int i = 0; i < nums.size(); i++)
        {
            if ((i & set_bit) != 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        cout << "Missing element: " << x << ", Duplicate element: " << y;
    }
};
