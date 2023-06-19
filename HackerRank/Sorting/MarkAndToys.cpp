#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int maximumToys(vector<int>& prices, int k) {
    sort(prices.begin(), prices.end());

    int count = 0;
    int sum = 0;
    for (int i = 0; i < prices.size(); i++) {
        if (sum + prices[i] <= k) {
            sum += prices[i];
            count++;
        } else {
            break;
        }
    }

    return count;
}