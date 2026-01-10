/**
 * @filename - Story1.cpp
 * @description -  The Project Builders Blueprint
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
using namespace std;

void printTaskHierarchy(vector<string> &tasks, int index, int indentLevel)
{
    // Base case
    if (index == tasks.size())
    {
        return;
    }

    for (int i = 0; i < indentLevel; i++)
    {
        cout << "  ";
    }

    cout << tasks[index] << endl;

    printTaskHierarchy(tasks, index + 1, indentLevel + 1);
}

int main()
{
    int totalTasks;
    cout << "Enter number of tasks (main + sub-tasks): ";
    cin >> totalTasks;

    cin.ignore();

    vector<string> tasks(totalTasks);

    for (int i = 0; i < totalTasks; i++)
    {
        if (i == 0)
            cout << "Enter main task: ";
        else
            cout << "Enter sub-task " << i << ": ";

        getline(cin, tasks[i]);
    }

    cout << "\nTask Hierarchy:\n";
    printTaskHierarchy(tasks, 0, 0);

    return 0;
}
