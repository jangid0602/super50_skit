/**
 * @filename - Story9.cpp
 * @description -  The Budget Calculator
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
using namespace std;

void calculateBudget(int items, vector<int> &costs, int budget, int index, vector<vector<int>> &itemList, vector<int> &currentList)
{

    if (budget == 0)
    {
        itemList.push_back(currentList);
        return;
    }
    if (budget < 0 || index == items)
        return;

    // Inclulde the current item
    currentList.push_back(costs[index]);
    calculateBudget(items, costs, budget - costs[index], index + 1, itemList, currentList);
    // Backtrack
    currentList.pop_back();
    calculateBudget(items, costs, budget, index + 1, itemList, currentList);
}
int main()
{
    int items;
    cout << "Enter number of items to budget: ";
    cin >> items;

    vector<int> costs(items);
    for (int i = 0; i < items; i++)
    {
        cout << "Enter cost of item " << i + 1 << ": ";
        cin >> costs[i];
    }

    int budget;
    cout << "Enter your total budget: ";
    cin >> budget;

    vector<vector<int>> itemList;
    vector<int> currentList;

    calculateBudget(items, costs, budget, 0, itemList, currentList);

    cout << "Possible combinations of items within budget are: " << endl;
    for (const auto &list : itemList)
    {
        cout << "[";
        for (const auto &cost : list)
        {
            cout << cost << " ";
        }
        cout << "]" << endl;
    }
}