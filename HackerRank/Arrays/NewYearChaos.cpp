#include <iostream>
#include <vector>

using namespace std;

void minimumBribes(const vector<int>& q) {
    int bribes = 0;
    bool tooChaotic = false;

    for (int i = 0; i < q.size(); ++i) {
        if (q[i] - (i + 1) > 2) {
            tooChaotic = true;
            break;
        }

        for (int j = max(0, q[i] - 2); j < i; ++j) {
            if (q[j] > q[i]) {
                bribes++;
            }
        }
    }

    if (tooChaotic) {
        cout << "Too chaotic" << endl;
    } else {
        cout << bribes << endl;
    }
}