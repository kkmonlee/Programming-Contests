#include <vector>
#include <map>
#include <algorithm>
#include <cmath>
#include <queue>

using namespace std;

class ReplacingDigit {
public:
    int getMaximumStockWorth(vector <int>, vector <int>);
};

int ReplacingDigit::getMaximumStockWorth(vector<int> A, vector<int> D) {
    vector<int> cache[10];
    for (int i = 0; i < A.size(); i++) {
        int j = 0, x = A[i];
        while (x) {
            cache[j].push_back(x % 10);
            x /= 10;
            j++;
        }
    }
    for (int i = 0; i < 10; i++)
        if (cache[i].size())
            sort(cache[i].begin(), cache[i].end());
    
    int total = 0;
    
    priority_queue<int> queue;
    for (int i = 0; i < D.size(); i++)
        for (int j = 0; j < D[i]; j++)
            queue.push(i + 1);
    
    for (int i = 0; i >= 0; i--)
        if (queue.size()) {
            for (int j = 0; j < cache[i][j]) {
                cache[i][j] = queue.top();
                queue.pop();
            }
        }
    int ans = 0;
    for (int i = 0; i < 10; i++)
        for (int j = 0; j < cache[i].size(); j++)
            ans += pow(10, i) * cache[i][j];
    
    return ans;
}
