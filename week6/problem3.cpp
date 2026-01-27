
/**
 * @filename   : problem3.cpp
 * @description: //  You are given n tasks and dependency relationships. 
 * Each task has a completion time. Find the minimum total time required to complete all tasks assuming tasks can run in parallel. 
 *  @author     : Ehtesham Nawaz
 */

//   time=[3,2,5], edges=[[0,2],[1,2]]  → 8 

#include<bits/stdc++.h>
using namespace std;




int timeToCompleteTask(vector< vector<int> >&adj,vector<int>&time,int node,vector<int>&dp){

    int minTime=0;
    if(dp[node]!=0) return dp[node];

    for(auto prerequisiteCourse: adj[node]){

        minTime = max(minTime,timeToCompleteTask(adj,time,prerequisiteCourse,dp) );

    }
    return  dp[node]=time[node]+minTime;

}



int main(){

    vector<int>time={3,2,5};
    vector<vector<int>>edges={{0,2},{1,2}};
    int n =time.size();
    vector<vector<int>>adj(n);

    vector<int>dp(n,0);

    vector<int>inDegree(n,0);

    for(auto edge:edges){
        int u=edge[0],v=edge[1];
        adj[v].push_back(u);
        inDegree[u]+=1;
    }

    int minimumTime=0;

    for(int i=0;i<n;i++){
        if(inDegree[i]==0){
            minimumTime= max(minimumTime,timeToCompleteTask(adj,time,i,dp));
        }
    }

    cout<<"Minimum time to complete all tasks is: "<<minimumTime<<endl;


return 0;
}