/*
Guess 2 points randomly and check if they define sufficient points.
Repeat 250 times

Probablity of being false: (1 - p^2)^250 ~ 10^(-5)
*/
#include <cstdio>
#include <cstdlib>
using namespace std;
typedef long long ll;

struct Point {
    ll x, y;
    Point(ll x = 0, ll y = 0):
            x(x), y(y) { }
    Point operator - (const Point &p) const {
        return Point(x - p.x, y - p.y);
    }

    ll cross(const Point &p) const {
        return x * p.y - y * p.x;
    }
};

int n, p;
Point P[1 << 20];

bool check() {
    if (n < 3) return true;
    for (int i = 0; i < 250; ++i) {
        int a = (int) random() % n;
        int b = (int) random() % n;
        int c = 0;
        if (a == b)
            continue;

        for (int j = 0; j < n; ++j) {
            c += !(P[j] - P[a]).cross(P[b] - P[a]);
        }

        if (100 * c >= p * n)
            return true;
    }
    return false;
}

int main() {
    scanf("%d%d", &n, &p);
    for (int i = 0; i < n; ++i) {
        scanf("%lld%lld", &P[i].x, &P[i].y);
    }

    printf("%spossible\n", check() ? "" : "im");
} 
