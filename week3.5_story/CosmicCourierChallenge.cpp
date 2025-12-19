/**
 * @filename   : CosmicCourierChallenge.cpp
 * @description: Determine the minimum possible project deadline by optionally removing one route travel time.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;

int minimizeDeadline(vector<int>& routes) {
    
    int numberOfRoutes=routes.size();
    

    sort(routes.begin(),routes.end());
    // edge case - if there is only one possible route given 
    if(routes.size()==1) return routes[0];

    return  routes[numberOfRoutes-2];
    
}
int main() {
    int numberOfRoutes;
    cin >> numberOfRoutes;               

    vector<int> routes(numberOfRoutes);
    for (int i = 0; i < numberOfRoutes; i++) {
        cin >> routes[i];     
    }

    int result = minimizeDeadline(routes);
    cout << result << endl;

    return 0;
}
