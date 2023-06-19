#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>

using namespace std;

void checkMagazine(const vector<string>& magazine, const vector<string>& note) {
    unordered_map<string, int> wordCount;

    for (const string& word : magazine) {
        wordCount[word]++;
    }

    for (const string& word : note) {
        if (wordCount[word] > 0) {
            wordCount[word]--;
        } else {
            cout << "No" << endl;
            return;
        }
    }

    cout << "Yes" << endl;
}