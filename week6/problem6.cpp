#include<bits/stdc++.h>
using namespace std;



/**
 * @filename   : problem6.cpp
 * @description: Detect Cycle in Directed Graph Using BFS
 * Example:
 *edges=[[0,1],[1,2],[2,0]]  → true 
 *  *  @author     : Ehtesham Nawaz
 */

 bool detectLoop(vector<vector<int>>&edges,int n){
    vector<int>inDegree(n,0);
    vector<vector<int>>adj(n);
    for(auto edge:edges){
        inDegree[edge[1]]+=1;
        adj[edge[0]].push_back(edge[1]);
    }
    queue<int>q;
    for(int i=0;i<n;i++){
        if(inDegree[i]==0) q.push(i);
    }
    int visitedCount=0;
    while(!q.empty()){
        auto node=q.front();
        visitedCount+=1;
        q.pop();

        for(auto nextNode:adj[node]){
            inDegree[nextNode]-=1;
            if(inDegree[nextNode]==0) q.push(nextNode);
        }
    }

    return visitedCount!=n;
 }
 
int main() {
    vector<vector<int>> edges = {
        {0, 1},
        {1, 2},
        {2, 0}
    };

    int n = 3;

    bool hasCycle = detectLoop(edges, n);

    if (hasCycle)
        cout << "Cycle detected\n";
    else
        cout << "No cycle detected\n";

    return 0;
}