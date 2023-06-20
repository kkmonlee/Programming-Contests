#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Player {
public:
    string name;
    int score;

    Player(string name, int score) {
        this->name = name;
        this->score = score;
    }
};

class Checker {
public:
    bool operator()(const Player& a, const Player& b) const {
        if (a.score == b.score) {
            return a.name < b.name;
        } else {
            return a.score > b.score;
        }
    }
};
