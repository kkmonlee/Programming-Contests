#include <iostream>
#include <vector>

using namespace std;

vector<int> rotLeft(const vector<int>& a, int d) {
    int n = a.size();
    vector<int> rotated(n);

    for (int i = 0; i < n; ++i) {
        int rotatedIndex = (i + (n - d)) % n;
        rotated[rotatedIndex] = a[i];
    }

    return rotated;
}