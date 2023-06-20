#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> climbingLeaderboard(vector<int> ranked, vector<int> player) {
    vector<int> ranks;
    vector<int> distinctRanked = {ranked[0]};

    for (int i = 1; i < ranked.size(); ++i) {
        if (ranked[i] != ranked[i - 1]) {
            distinctRanked.push_back(ranked[i]);
        }
    }

    int n = distinctRanked.size();
    int m = player.size();
    int i = n - 1; // index for leaderboard
    int j = 0; // index for player scores

    while (j < m) {
        if (i >= 0 && player[j] >= distinctRanked[i]) {
            ranks.push_back(i + 1);
            j++;
        } else i--;
    }

    while (j < m) {
        ranks.push_back(i + 1);
        j++;
    }

    return ranks;
}