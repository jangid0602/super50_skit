/**
 * @filename   : story2.cpp
 * @description: Encoded String Subsets
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

bool checkSubsetEncoded(string big, string small) {
    unordered_map<char, int> subCount;
    for (char ch : small) subCount[ch]++;

    int win = small.size();
    unordered_map<char, int> window;
    int left = 0;

    for (int right = 0; right < big.size(); right++) {
        window[big[right]]++;
        if (right - left + 1 > win) {
            window[big[left]]--;
            if (window[big[left]] == 0) window.erase(big[left]);
            left++;
        }
        if (right - left + 1 == win) {
            bool ok = true;
            for (auto& p : window) {
                if (!subCount.count(p.first) || subCount[p.first] < p.second) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
    }
    return false;
}

int main() {
    string a, b;
    cout << "Enter superstring: ";
    cin >> a;
    cout << "Enter substring: ";
    cin >> b;

    cout << (checkSubsetEncoded(a, b) ? "True" : "False") << endl;
    return 0;
}
