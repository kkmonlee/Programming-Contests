#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

using namespace std;
using ll = long long;
using ld = long double;
using vi = vector<int>;

const ld LLINFINITY = 1e300;

struct S {
    int v;
    const int r;
    ll f;
    const ll cap;
    const ld cost;
    S(int v, int reverse_index, ll capacity, ld cost = 0) :
            v(v), r(reverse_index), f(0), cap(capacity), cost(cost) { }
};;

struct FlowGraph : vector<vector<S>> {
    FlowGraph(size_t n) : vector<vector<S>>(n) { }
    void add_edge(int u, int v, ll capacity, ld cost = 0) {
        operator[](u).emplace_back(v, operator[](v).size(), capacity, cost);
        operator[](v).emplace_back(u, operator[](u).size() - 1, 0, -cost);
    }
};

struct Q{
    int u;
    ll c;
    ld w;
};

bool operator>(const Q &l, const Q &r) {
    return l.w > r.w;
}

struct EdmondsKarpDijkstra {
    FlowGraph &g;
    int V, s, t;
    vector<ld> pot;
    EdmondsKarpDijkstra(FlowGraph &g, int s, int t) :
            g(g), V(g.size()), s(s), t(t), pot(V) { }
    pair<ll, ld> run() {
        ll maxflow = 0;
        ld cost = 0;
        fill(pot.begin(), pot.end(), 0);
        for (int u = 0; u < V; ++u) if (pot[u] + 1 < LLINFINITY)
                pot[u] = 0;
        while (true) {
            priority_queue<Q, vector<Q>, greater<Q>> q;
            vector<vector<S>::iterator> p(V, g.front().end());
            vector<ld> dist(V, LLINFINITY);
            ll f, tf = -1;
            q.push({
                    s, ll(1e18),  0
                   });
            dist[s] = 0;
            while (!q.empty()) {
                auto u = q.top().u;
                ld w = q.top().w;
                f = q.top().c;
                q.pop();
                if (w != dist[u])
                    continue;
                if (u == t && tf < 0)
                    tf = f;
                for (auto it = g[u].begin(); it != g[u].end(); it++) {
                    const auto &e = *it;
                    ld d = w + e.cost + pot[u] - pot[e.v];
                    if (e.cap > e.f && d < dist[e.v]) {
                        q.push({
                                e.v, min(f, e.cap - e.f), dist[e.v] = d
                               });
                        p[e.v] = it;
                    }
                }
            }
            auto it = p[t];
            if (it == g.front().end())
                return {maxflow, cost};
            maxflow += f = tf;
            while (it != g.front().end()) {
                auto & r = g[it->v][it->r];
                cost += f * it->cost;
                it->f+=f;
                r.f -= f;
                it = p[r.v];
            }
            for (int u = 0; u < V; ++u)
                if (dist[u] + 1 < LLINFINITY)
                    pot[u] += dist[u];
        }
    };
};

inline ll llsq(int x) {
    return ll(x) * ll(x);
}

void dijkstra(vector<vector<pair<int, ld>>> &e, vector<ld> &dist, int u) {
    dist[u] = 0.0;
    priority_queue<pair<ld, int>, vector<pair<ld, int>>, greater<pair<ld, int>>> pq;
    pq.push({dist[u], u});
    while (!pq.empty()) {
        int v = pq.top().second;
        ld dis = pq.top().first;
        pq.pop();
        if (dist[v] != dis) continue;
        for (pair<int, ld> pp : e[v]) {
            int w = pp.first;
            ld wg = pp.second;
            if (dist[w] > dis + wg) {
                dist[w] = dis + wg;
                pq.push({dist[w], w});
            }
        }
    }
}

int main() {
    int n, s, t, _q;
    scanf("%d %d %d %d", &n, &s, &t, &_q);
    ll qq = llsq(_q);

    FlowGraph fg(n + 2);
    int SOURCE = n, SINK = n + 1;

    vi x(n, 0), y(n, 0), h(n, 0);
    vector<vector<pair<int, ld>>> e(n, vector<pair<int, ld>>());

    for (int i = 0; i < n; ++i) {
        scanf("%d %d %d", &x[i], &y[i], &h[i]);
        for (int j = 0; j < i; ++j) {
            if (h[i] == h[j])
                continue;
            ll distsq = llsq(x[i] - x[j]) + llsq(y[i] - y[j]) + llsq(h[i] - h[j]);
            if (distsq > qq)
                continue;
            ld dist = sqrt(ld(distsq));
            if (h[i] > h[j])
                e[i].push_back({j, dist});
            if (h[i] < h[j])
                e[j].push_back({i, dist});
        }
    }

    vector<vector<ld>> dist(n, vector<ld>(n, LLINFINITY));
    for (int u = 0; u < n; ++u) {
        dijkstra(e, dist[u], u);
    }

    vi sprs;
    for (int i = 0; i < s; ++i) {
        int spr;
        scanf("%d", &spr);
        fg.add_edge(SOURCE, spr - 1, 1, 0);
        sprs.push_back(spr - 1);
    }

    for (int i = 0; i < t; ++i) {
        int snk;
        scanf("%d", &snk);
        fg.add_edge(snk - 1, SINK, 1, 0);
        for (int ss : sprs)
            fg.add_edge(ss, snk - 1, 1, dist[ss][snk - 1]);
    }

    EdmondsKarpDijkstra dn(fg, SOURCE, SINK);
    pair<ll, ld> ans = dn.run();

    if (ans.first < t)
        cout << "IMPOSSIBLE" << endl;
    else
        printf("%.8lf\n", double(ans.second));

    return 0;
} 
