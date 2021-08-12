// For problem statement, see [StockBuySell.java]

#include <iostream>
#include <vector>
using namespace std;

class StockBuySell
{
public:
    int findProfit(vector<int> &prices)
    {
        int minPrice = INT_MAX;
        int profit = 0;

        for (int i = 0; i < prices.size(); i++)
        {
            minPrice = min(minPrice, prices[i]);
            profit = max(profit, prices[i] - minPrice);
        }

        return profit;
    }
};

int main()
{
    vector<int> prices{7, 1, 5, 3, 6, 4};
    StockBuySell stockBuySell;
    int profit = stockBuySell.findProfit(prices);

    cout << profit << endl;
    return 0;
}
