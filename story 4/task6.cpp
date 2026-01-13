/**
 * @filename - Task6.cpp
 * @description - The Perfect Team Assembly (Backtracking/Subsets) 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;

void generateTeams(vector<string>& names, int index, vector<vector<string>>& allTeams, vector<string>& currentTeam) {
    if (index == names.size()) {
        allTeams.push_back(currentTeam);
        return;
    }

    currentTeam.push_back(names[index]);
    generateTeams(names, index + 1, allTeams, currentTeam);
    currentTeam.pop_back();
    generateTeams(names, index + 1, allTeams, currentTeam);
}

int main() {
    int count;
    cout << "Enter number of developers: ";
    cin >> count;

    vector<string> names(count);
    vector<vector<string>> allTeams;
    vector<string> currentTeam;

    cout << "Enter names: ";
    for (int i = 0; i < count; i++) {
        cin >> names[i];
    }

    generateTeams(names, 0, allTeams, currentTeam);

    for (auto& team : allTeams) {
        cout << "[";
        for (auto& dev : team) {
            cout << dev << " ";
        }
        cout << "]";
    }

    return 0;
}
