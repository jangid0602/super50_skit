/**
 * @filename - Task-3.cpp
 * @description - The Digital Ancestry Tree
 * @author - Diya Garg
 */

#include <iostream>
#include <vector>
using namespace std;

vector<int> wealth;
vector<vector<int>> children;

int calculateLegacy(int person)
{
    int total = wealth[person];

    for (int child : children[person])
    {
        total += calculateLegacy(child);
    }

    return total;
}

int main()
{
    int n;
    cout << "Enter number of persons: ";
    cin >> n;

    // index 1-based, so size = n+1
    wealth.resize(n + 1);
    children.resize(n + 1);

    cout << "\nEnter wealth of each person:\n";
    for (int i = 1; i <= n; i++)
    {
        cout << "Person " << i << ": ";
        cin >> wealth[i];
    }

    cout << "\nEnter children details:\n";
    for (int i = 1; i <= n; i++)
    {
        int c;
        cout << "Number of children of person " << i << ": ";
        cin >> c;

        if (c > 0)
        {
            cout << "Enter children indices: ";
            for (int j = 0; j < c; j++)
            {
                int child;
                cin >> child;
                children[i].push_back(child);
            }
        }
    }

    int root;
    cout << "\nEnter root person index: ";
    cin >> root;

    cout << "\nTotal Legacy: " << calculateLegacy(root);

    return 0;
}
