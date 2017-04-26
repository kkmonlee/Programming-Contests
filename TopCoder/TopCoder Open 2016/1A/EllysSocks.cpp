#include <vector>
#include <map>
#include <algorithm>
#include <cstring>

using namespace std;

class EllysSocks {
public:
    double getDifference(vector <int>, int);
};

bool vision[2000];
double EllysSocks::getDifference(vector<int> S, int P) {
    sort(S.begin(), S.end());
    
    double l = 0;
    double r = 1e9 + 7;
    
    while (l < r) {
        double mid = (l + r) / 2;
        memset(vision, 0, sizeof vision);
        int total = 0;
        for (int i = 0; i < S.size(); i++) {
            if (!vision[i])
                for (int j = i + 1; j < S.size(); j++)
                    if (!vision[j] && S[j] - S[i] <= mid) {
                        total++;
                        vision[i] = vision[j] = true;
                        break;
                    }
        }
        if (total >= P)
            r = mid;
        else l = mid + 1;
    }
    return l;
}
