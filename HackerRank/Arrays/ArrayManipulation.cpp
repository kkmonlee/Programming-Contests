#include <iostream>
#include <vector>

using namespace std;

long arrayManipulation(int n, vector<vector<int>>& queries) {
    vector<long long> arr(n + 1, 0);

    for (const vector<int>& query : queries) {
        int a = query[0];
        int b = query[1];
        int k = query[2];

        arr[a] += k;
        if (b + 1 <= n) {
            arr[b + 1] -= k;
        }
    }

    long long maxVal = 0;
    long long currVal = 0;

    for (int i = 1; i <= n; ++i) {
        currVal += arr[i];
        maxVal = max(maxVal, currVal);
    }

    return maxVal;
}