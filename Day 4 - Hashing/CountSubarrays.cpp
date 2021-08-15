// For problem statement, see [CountSubarrays.java]

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class CountSubarrays
{
public:
    int countSubarrays(vector<int> A, int B)
    {
        unordered_map<int, int> freq;
        int xorr = 0;
        int cnt = 0;
        int n = A.size();
        for (int i = 0; i < n; i++)
        {
            xorr = xorr ^ A[i];
            if (freq.find(xorr ^ B) != freq.end())
                cnt += freq[xorr ^ B];
            if (xorr == B)
                cnt += 1;
            // if (freq.find(xorr) != freq.end()) freq[xorr] = freq[xorr] + 1;
            // else freq[xorr] = 1;
            freq[xorr] += 1;
        }
        return cnt;
    }
};
