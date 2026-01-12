/**
 * @filename - Task-10.cpp
 * @description - The Project Builder's Blueprint
 * @author - Diya Garg
 */

#include <bits/stdc++.h>
using namespace std;

void printTasks(vector<string> &tasks, int index, int level)
{
    if (index == tasks.size())
        return;

    for (int i = 0; i < level; i++)
        cout << "  ";

    cout << tasks[index] << endl;

    printTasks(tasks, index + 1, level + 1);
}

int main()
{
    int n;
    cin >> n;

    vector<string> tasks(n);
    cin.ignore();

    for (int i = 0; i < n; i++)
        getline(cin, tasks[i]);

    printTasks(tasks, 0, 0);
    return 0;
}
