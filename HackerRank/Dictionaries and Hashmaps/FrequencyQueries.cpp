#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

vector<int> freqQuery(vector<vector<int>>& queries) {
    unordered_map<int, int> dataFreq;
    unordered_map<int, int> freqCount;
    vector<int> results;

    for (auto query : queries) {
        int operation = query[0];
        int element = query[1];

        if (operation == 1) {
            int prevFreq = dataFreq[element];
            int newFreq = prevFreq + 1;
            dataFreq[element] = newFreq;
            freqCount[prevFreq]--;
            freqCount[newFreq]++;
        } else if (operation == 2) {
            int prevFreq = dataFreq[element];
            if (prevFreq > 0) {
                int newFreq = prevFreq - 1;
                dataFreq[element] = newFreq;
                freqCount[prevFreq]--;
                freqCount[newFreq]++;
            }
        } else if (operation == 3) {
            int count = freqCount[element] > 0 ? 1 : 0;
            results.push_back(count);
        }
    }

    return results;
}