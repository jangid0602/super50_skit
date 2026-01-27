#include<bits/stdc++.h>
using namespace std;

/**
 * @filename   : problem1.cpp
 * @description: directed graph representing flight routes between n cities.find flight route from source to destination city.
 * @author     : Ehtesham Nawaz
 */

 int flightWithinKstops(vector<vector<int>>& flights, int n, int src, int dst, int k) {
        vector<vector<pair<int,int>>> adj(n);

        for(auto flight: flights){
            adj[flight[0]].push_back({flight[1], flight[2]});
        }
        
        vector<int> dist(n, INT_MAX);
        dist[src] = 0;
        
        queue<pair<int,pair<int,int>>> q;
        q.push({0, {src, 0}}); //
        
        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int stops = it.first;
            int node = it.second.first;
            int cost = it.second.second;
            
            if(stops > k) continue;
            
            for(auto next: adj[node]){
                int nextNode = next.first;
                int nextCost = next.second;
                
                if(cost + nextCost < dist[nextNode] && stops <= k){
                    dist[nextNode] = cost + nextCost;
                    q.push({stops + 1, {nextNode, dist[nextNode]}});
                }
            }
        }
        
        return dist[dst] == INT_MAX ? -1 : dist[dst];
    }



int main(){
    vector<vector<int>> flights = {
        {0, 1, 100},
        {1, 2, 100},
        {0, 2, 500}
    };
    int n = 3; // number of cities
    int src = 0; // source city
    int dst = 2; // destination city
    int k = 1; // maximum number of stops

    int result = flightWithinKstops(flights, n, src, dst, k);
    cout << "Cheapest price from city " << src << " to city " << dst << " with at most " << k << " stops is: " << result << endl;

return 0;
}