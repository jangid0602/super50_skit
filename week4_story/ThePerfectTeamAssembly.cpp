/**
 * @filename   : PerfectTeamAssembly.cpp
 * @description: Generate all possible team combinations using backtracking.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;

void generateTeams(int index,
                   vector<string>& developers,
                   vector<string>& currentTeam,
                   vector<vector<string>>& allTeams) {

    
    if (index == developers.size()) {
        allTeams.push_back(currentTeam);
        return;
    }

    
    currentTeam.push_back(developers[index]);
    generateTeams(index + 1, developers, currentTeam, allTeams);

    
    currentTeam.pop_back();
    generateTeams(index + 1, developers, currentTeam, allTeams);
}

int main() {
    vector<string> developers = {"DevA", "DevB"};
    vector<string> currentTeam;
    vector<vector<string>> allTeams;

    generateTeams(0, developers, currentTeam, allTeams);

    
    for (const auto& team : allTeams) {
        if (team.empty()) {
            cout << "Empty Team";
        } else {
            for (const auto& dev : team)
                cout << dev << " ";
        }
        cout << endl;
    }

    return 0;
}
