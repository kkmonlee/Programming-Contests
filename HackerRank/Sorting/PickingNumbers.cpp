#include <iostream>
#include <vector>
#include <algorithm>

int pickingNumbers(std::vector<int> a) {
    std::vector<int> frequency(100, 0);

    for (int num : a) {
        frequency[num]++;
    }

    int maxLength = 0;

    for (int i = 1; i < 100; ++i) {
        maxLength = std::max(maxLength, frequency[i] + frequency[i - 1]);
    }

    return maxLength;
}