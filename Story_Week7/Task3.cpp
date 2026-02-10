/**
 * @filename - Task3.cpp
 * @description -  The Minimal Tech-Stack Swap 
 * @author - Ayushi Shukla
 */
#include<iostream>
#include<vector>
using namespace std;

int solve(int i, int j, string &str1, string &str2,
          int C_i, int C_d, int C_u,
          vector<vector<int>>& dp) {

    
    if(i == str1.length())
        return (str2.length() - j) * C_i;   
    if(j == str2.length())
        return (str1.length() - i) * C_d;   

    if(dp[i][j] != -1) return dp[i][j];

  
    if(str1[i] == str2[j]) {
        return dp[i][j] = solve(i+1, j+1, str1, str2, C_i, C_d, C_u, dp);
    }

    int insertOp  = C_i + solve(i, j+1, str1, str2, C_i, C_d, C_u, dp);
    int deleteOp  = C_d + solve(i+1, j, str1, str2, C_i, C_d, C_u, dp);
    int upgradeOp = C_u + solve(i+1, j+1, str1, str2, C_i, C_d, C_u, dp);

    return dp[i][j] = min(insertOp, min(deleteOp, upgradeOp));
}

int main() {
    string str1, str2;
    cout << "Enter string 1: ";
    cin >> str1;
    cout << "Enter string 2: ";
    cin >> str2;

    int C_i, C_d, C_u;
    cout << "Enter insert cost: ";
    cin >> C_i;
    cout << "Enter delete cost: ";
    cin >> C_d;
    cout << "Enter upgrade cost: ";
    cin >> C_u;

    vector<vector<int>> dp(str1.length()+1, vector<int>(str2.length()+1, -1));

    int ans = solve(0, 0, str1, str2, C_i, C_d, C_u, dp);
    cout << "Minimum cost = " << ans << endl;

    return 0;
}