/**
 * @filename - Task5.cpp
 * @description - Optimal Server Latency (Partition DP)
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <climits>
using namespace std;


vector<vector<int>> computeUnbalanceCost(const vector<int> &serverPower)
{
    int n = serverPower.size();
    vector<vector<int>> cost(n, vector<int>(n, 0));

    for (int start = 0; start < n; start++)
    {
        int minimumPower = serverPower[start];
        int maximumPower = serverPower[start];

        for (int end = start; end < n; end++)
        {
            minimumPower = min(minimumPower, serverPower[end]);
            maximumPower = max(maximumPower, serverPower[end]);
            cost[start][end] = maximumPower - minimumPower;
        }
    }
    return cost;
}


int minimizeTotalUnbalance(const vector<int> &serverPower, int clusters)
{
    int n = serverPower.size();

    vector<vector<int>> unbalanceCost = computeUnbalanceCost(serverPower);

    vector<vector<int>> dp(clusters + 1, vector<int>(n, INT_MAX));

    
    for (int i = 0; i < n; i++)
        dp[1][i] = unbalanceCost[0][i];

   
    for (int currentCluster = 2; currentCluster <= clusters; currentCluster++)
    {
        for (int lastServer = 0; lastServer < n; lastServer++)
        {
            for (int partitionPoint = 0; partitionPoint < lastServer; partitionPoint++)
            {
                if (dp[currentCluster - 1][partitionPoint] != INT_MAX)
                {
                    dp[currentCluster][lastServer] = min(
                        dp[currentCluster][lastServer],
                        dp[currentCluster - 1][partitionPoint] +
                            unbalanceCost[partitionPoint + 1][lastServer]);
                }
            }
        }
    }

    return dp[clusters][n - 1];
}

int main()
{
    int numberOfServers, numberOfClusters;
    cout << "Enter number of servers and number of clusters :";
    cin >> numberOfServers >> numberOfClusters;

    vector<int> serverPower(numberOfServers);
    cout << "Enter server powers : " << endl;
    for (int i = 0; i < numberOfServers; i++)
        cin >> serverPower[i];

    cout << "Minimum total unbalance: " << minimizeTotalUnbalance(serverPower, numberOfClusters) << endl;
    return 0;
}