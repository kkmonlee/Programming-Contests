#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

long countTriplets(vector<long>& arr, long r) {
    unordered_map<long, long> freq;
    unordered_map<long, long> second;
    long triplets = 0;

    for (long num : arr) {
        if (second.count(num))
            triplets += second[num];

        if (freq.count(num))
            second[num * r] += freq[num];

        freq[num * r]++;
    }

    return triplets;
}