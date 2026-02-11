/**
 * @filename - Task9.cpp
 * @description - The Budget Calculator (Backtracking)
 * @author - Disha Toshniwal 
 */
#include <bits/stdc++.h>
using namespace std;
void solve(int idx, vector<int>& prices, int remaining,
           vector<int>& current, vector<vector<int>>& result) {

    if (remaining == 0) {               
        result.push_back(current);
        return;
    }
    if (remaining < 0) return;          

    for (int i = idx; i < prices.size(); i++) {
        current.push_back(prices[i]);
        solve(i, prices, remaining - prices[i], current, result);
        current.pop_back();
    }
}

vector<vector<int>> budgetCombinations(vector<int>& prices, int budget) {
    vector<vector<int>> result;
    vector<int> current;
    solve(0, prices, budget, current, result);
    return result;
}

int main() {
    int n, budget;
    cout << "Enter number of items: ";
    cin >> n;

    vector<int> prices(n);
    cout << "Enter item prices: ";
    for(int i = 0; i < n; i++) cin >> prices[i];

    cout << "Enter budget: ";
    cin >> budget;

    vector<vector<int>> ans = budgetCombinations(prices, budget);

    cout << "Combinations: ";
    if(ans.empty()) {
        cout << "None";
    } else {
        for (auto &comb : ans) {
            cout << "[ ";
            for (int x : comb) cout << x << " ";
            cout << "]";
        }
    }

    return 0;
}
