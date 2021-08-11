// For problem statement, see [MergeArrays.java]

#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

class MergeArrays
{
public:
    void merge(vector<int> &left, vector<int> &right)
    {
        for (int i = 0; i < left.size(); i++)
            if (left[i] > right[0])
            {
                swap(left[i], right[0]);
                sort(right.begin(), right.end());
            }
    }
};

int main()
{
    vector<int> left{1, 4, 7, 8, 10};
    vector<int> right{2, 3, 9};

    MergeArrays mergeArrays;
    mergeArrays.merge(left, right);

    cout << "Left array: ";
    for (int i = 0; i < left.size(); i++)
        cout << left[i] << " ";

    cout << endl
         << "Right array: ";
    for (int i = 0; i < right.size(); i++)
        cout << right[i] << " ";

    return 0;
}
