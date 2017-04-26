/**
 * Dijkstra's algorithm - shortest path
 * 
 * Finding distance to the car
 * Each Element is weighted
 * I push all edge doors into a priority queue
 */

#include <iostream>
#include <queue>
#include <array>
using namespace std;

#define SIZE 400 * 400

// Element contains the type and array of links to other Elements
typedef struct Element {
    char type;
    bool finish = false;
    int minDistance = SIZE + 1;
    vector<Element *> adj;
} Element;

struct compareElements {
    bool operator() (Element const &a, Element const &b) const {
        return a.minDistance > b.minDistance;
    }
};

// All of the edge doors
typedef priority_queue<Element, vector<Element>, compareElements> priorityQueue;

int shortestPath(priorityQueue &unvisited) {
    while (unvisited.size() > 0) {
        auto current = unvisited.top();
        unvisited.pop();
        if (current.finish) {
            return current.minDistance;
        }

        for (auto const &neighbour : current.adj) {
            int length = neighbour -> type == 'D' ? 0 : 1;
            if (neighbour -> minDistance > current.minDistance + length) {
                neighbour -> minDistance = current.minDistance + length;
                unvisited.push(*neighbour);
            }
        }
    }
    return -1;
};

int main() {
    // read data
    int input;
    int w, l, x, y;
    input = scanf(" %d %d", &l, &w);

    vector<Element> map((unsigned long) (w * l));
    array<vector<Element *>, SIZE + 1> adj;
    char line[500];

    for (int i = 0; i < l; i++) {
        input = scanf(" %s", line);
        for (int j = 0; j < w; j++) {
            map[j + (i * w)].type = line[j];
        }
    }

    input = scanf(" %d %d", &y, &x);
    x--;
    y--;
    map[x + (y * w)].finish = true;

    // build the graph
    for (int j = 0; j < (l * w); j++) {
        input = scanf(" %s", line);
        if (map[j].type == '#') {
            continue;
            // we dont need what's next to walls
        }

        // if not in first row, look up a row
        if (j > (w - 1)) {
            if (map[j - w].type == 'c' || map[j - w].type == 'D') {
                map[j].adj.push_back(&(map[j - w]));
            }
        }

        // if not in last row, look down a row
        if (j < (l * w) - (w - 1)) {
            if (map[j + w].type == 'c' || map[j + w].type == 'D') {
                map[j].adj.push_back(&(map[j + w]));
            }
        }

        // if not in first column, look back a column
        if (j % w > 0) {
            if (map[j - 1].type == 'c' || map[j - 1].type == 'D') {
                map[j].adj.push_back(&(map[j - 1]));
            }
        }

        // if not in last column, look forward a column
        if ((j % w) != (w - 1)) {
            if (map[j + 1].type == 'c' || map[j + 1].type == 'D') {
                map[j].adj.push_back(&(map[j + 1]));
            }
        }
    }

    // find each door outside
    vector<int> doors;

    for (int i = 0; i < l * w; i++) {
        if (i > l * w - (w + 1)) {
            if (map[i].type == 'D') {
                doors.push_back(i);
            }
        } else {
            if (i < w || (i % w == 0)) {
                if (map[i].type == 'D') {
                    doors.push_back(i);
                }
            } else {
                if (i % w == w - 1) {
                    if (map[i].type == 'D') {
                        doors.push_back(i);
                    }
                }
            }
        }
    }

    int shortest = SIZE + 1;
    int door_shortest;
    Element *start;

    // make a list of unvisited nodes and init each of them
    priorityQueue unvisited;
    for (unsigned it = 0; it < doors.size(); it++) {
        map[doors[it]].minDistance = 0;
        unvisited.push(map[doors[it]]);
    }

    for (int i = 0; i < w * l; i++) {
        if (map[i].type != '#' and map[i].type != 'D') {
            map[i].minDistance = SIZE + 1;
            unvisited.push(map[i]);
        }
    }

    cout << shortestPath(unvisited) << "\n";
}; 
