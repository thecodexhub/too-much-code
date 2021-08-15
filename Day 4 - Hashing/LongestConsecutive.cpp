// For problem statement, see [LongestConsecutive.java]

#include <iostream>
#include <vector>
#include <set>
using namespace std;

class LongestConsecutive
{
public:
    int longestConsecutive(vector<int> &nums)
    {
        set<int> hashSet;
        for (int n : nums)
            hashSet.insert(n);

        int longestStreak = 0;
        for (int n : nums)
        {
            if (!hashSet.count(n - 1))
            {
                int currentNumber = n;
                int currentStreak = 1;
                while (hashSet.count(currentNumber + 1))
                {
                    currentStreak += 1;
                    currentNumber += 1;
                }
                longestStreak = max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
};
