#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <functional>
#include <sstream>
#include <iomanip>

using namespace std;

class ExploringNumbers {
public:
    int numberOfSteps(int);
};

bool check(int x) {
    if (x == 1) 
        return false;
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0)
            return false;
    }
    return true;
}

int square(int x) {
    return x * x;
}

set<int> s;

int ExploringNumbers::numberOfSteps(int n) {
    int len = 0;
    int n_ = n;
    while (len < n_) {
        len++;
        s.insert(n);
        if (check(n)) 
            break;
        else {
            int t = 0;
            while (n) {
                t += square(n % 10);
                n /= 10;
            }
            if (s.find(t) != s.end()) {
                len = n_ + 1;
                break;
            }
            n = t;
        }
    }
    if (len < n_)
        return len;
    
    return 69;
}
