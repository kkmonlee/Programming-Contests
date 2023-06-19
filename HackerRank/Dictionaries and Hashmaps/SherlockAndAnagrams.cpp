#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

int sherlockAndAnagrams(const string& s) {
    int count = 0;
    unordered_map<string, int> substrings;

    // Generate all possible substring and count their occurrences
    for (int i = 0; i < s.length(); i++) {
        for (int j = 1; j <= s.length() - i; j++) {
            string substr = s.substr(i, j);
            sort(substr.begin(), substr.end());

            count += substrings[substr];
            substrings[substr]++;
        }
    }

    return count;
}