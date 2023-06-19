#include <iostream>
#include <vector>
#include <limits>

using namespace std;

int hourglassSum(const vector<vector<int>>& arr) {
    int maxSum = numeric_limits<int>::min();

    for (int i = 0; i <= 3; ++i) {
        for (int j = 0; j <= 3; ++j) {
            int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j]
                        + arr[i + 2][j + 1]
                        + arr[i + 2][j + 2];
            maxSum = max(maxSum, sum);
        }
    }

    return maxSum;
}