/**
 * @filename - Task6.cpp
 * @description - The Perfect Team Assembly 
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <vector>
using namespace std;

void teams(int i, vector<string>& members, vector<string>& curr) {

    // base case
    if (i == members.size()) {
        cout << "[";
        for (int j = 0; j < curr.size(); j++) {
            cout << curr[j];
            if (j < curr.size() - 1) cout << ", ";
        }
        cout << "]\n";
        return;
    }

    // include
    teams(i + 1, members, curr);

    // exclude
    curr.push_back(members[i]);
    teams(i + 1, members, curr);

    // BACKTRACK
    curr.pop_back();
}

int main() {
    int n;
    cout << "Enter number of members: ";
    cin >> n;

    vector<string> members(n);
    cout << "Enter member names:\n";
    for (int i = 0; i < n; i++) {
        cin >> members[i];
    }

    vector<string> curr;
    cout << "\nAll team combinations:\n";
    teams(0, members, curr);

    return 0;
}
