#include <iostream>
#include <unordered_set>
#include <string>

using namespace std;

string twoStrings(const string& s1, const string& s2) {
    unordered_set<char> charSet;

    // Add all characters from s1 to the set
    for (char ch : s1) {
        charSet.insert(ch);
    }

    // Check if any character from s2 is present in the set
    for (char ch : s2) {
        if (charSet.count(ch) > 0) {
            return "YES";
        }
    }

    return "NO";
}