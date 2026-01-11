/**
 * @filename - Task7.cpp
 * @description - The Secure Vault Code (Backtracking/Permutations)
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;

void generateCodes(vector<int>& digits, vector<bool>& used, vector<int>& current, vector<vector<int>>& allCodes) {
    if (current.size() == digits.size()) {
        allCodes.push_back(current);
        return;
    }

    for (int i = 0; i < digits.size(); i++) {
        if (!used[i]) {
            used[i] = true;
            current.push_back(digits[i]);

            generateCodes(digits, used, current, allCodes);

            used[i] = false;
            current.pop_back();
        }
    }
}

int main() {
    vector<int> digits(3);
    cout << "Enter digits: ";
    for (int i = 0; i < 3; i++) {
        cin >> digits[i];
    }

    vector<bool> used(3, false);
    vector<int> current;
    vector<vector<int>> allCodes;

    generateCodes(digits, used, current, allCodes);

    cout << "All possible unique vault codes:\n";
    for (auto& code : allCodes) {
        for (int d : code) {
            cout << d;
        }
        cout << endl;
    }

    return 0;
}
