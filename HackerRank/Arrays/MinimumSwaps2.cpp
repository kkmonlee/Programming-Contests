#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int minimumSwaps(vector<int>& arr) {
    int swaps = 0;
    int n = arr.size();
    unordered_map<int, int> indexMap;

    for (int i = 0; i < n; ++i) {
        indexMap[arr[i]] = i;
    }

    for (int i = 0; i < n; ++i) {
        if (arr[i] != i + 1) {
            int correctNum = i + 1;
            int currentIndex = i;
            int correctIndex = indexMap[correctNum];

            swap(arr[currentIndex], arr[correctIndex]);
            swap(indexMap[arr[currentIndex]], indexMap[arr[correctIndex]]);

            swaps++;
            i--;
        }
    }

    return swaps;
}
