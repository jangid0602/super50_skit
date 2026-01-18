/**
 * @filename   : BudgetCalculator.cpp
 * @description: Find all combinations of item prices that sum to a given budget using backtracking.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <vector>
using namespace std;

void findCombinations(int index,
                      vector<int> &prices,
                      int remainingBudget,
                      vector<int> &currentCombination,
                      vector<vector<int>> &allCombinations)
{
    if (remainingBudget == 0)
    {
        allCombinations.push_back(currentCombination);
        return;
    }
    if (index < 0)
        return;

    if (prices[index] <= remainingBudget)
    {
        currentCombination.push_back(prices[index]);
        findCombinations(index, prices, remainingBudget - prices[index], currentCombination, allCombinations);
        currentCombination.pop_back();
    }
    findCombinations(index - 1, prices, remainingBudget, currentCombination, allCombinations);
}
int main()
{
    vector<int> prices = {2, 3};
    int budget = 5;

    vector<int> currentCombination;
    vector<vector<int>> allCombinations;

    int numberOfItems = prices.size();

    findCombinations(numberOfItems - 1,
                     prices,
                     budget,
                     currentCombination,
                     allCombinations);

        for (const auto &combination : allCombinations)
    {
        for (int price : combination)
            cout << price << " ";
        cout << endl;
    }

    return 0;
}
