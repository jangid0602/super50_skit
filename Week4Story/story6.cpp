/**
 * @filename - Story1.cpp
 * @description -  Perfect team assembly
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <string>
using namespace std;
void assembleTeam(vector<string> &developers, int index, vector<vector<string>> &result, vector<string> &currentTeam, int totalSpecialist)
{

    if (index == totalSpecialist)
    {
        result.push_back(currentTeam);
        return;
    }

    // Include the current developer
    currentTeam.push_back(developers[index]);
    assembleTeam(developers, index + 1, result, currentTeam, totalSpecialist);

    // Backtrack
    currentTeam.pop_back();
    assembleTeam(developers, index + 1, result, currentTeam, totalSpecialist);
}
int main()
{
    int totalSpecialist;
    cout << "Enter number of total specialist developers: ";
    cin >> totalSpecialist;
    vector<string> developerList;
    cin.ignore();

    for (int i = 0; i < totalSpecialist; i++)
    {
        string name;
        cout << "Enter name of developer " << i + 1 << ": ";
        getline(cin, name);
        developerList.push_back(name);
    }

    vector<vector<string>> totalPerfectTeams;
    vector<string> currentTeam;
    assembleTeam(developerList, 0, totalPerfectTeams, currentTeam, totalSpecialist);

    cout << "Total possible perfect teams are : " << endl;

    for (const auto &team : totalPerfectTeams)
    {
        cout << "[";
        for (const auto &member : team)
        {
            cout << member << " ";
        }
        cout << "]" << endl;
    }
}