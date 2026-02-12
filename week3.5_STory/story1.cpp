/**
 * @filename - Story1.cpp
 * @description -  The Cosmic Courier challenge 
 * @author - Fatimi Bee
 */

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    cout<<"Enter the total number of routes : ";
    int routes;
    cin>>routes;

    vector<int>routeTravelTime(routes,0);

    for(int i=0;i<routes ;i++){
        cout<<"Enter the route "<<i+1<<" travel time : ";
        cin>>routeTravelTime[i];
    }

    //  Edge case : if there is only one route then we cannot remove any route so the deadline is travel time of that only route
    if(routes == 1){
        cout<<"The minimum possible deadline is : " <<routeTravelTime[0]<<endl;
        return 0;
    }

    sort(routeTravelTime.begin() , routeTravelTime.end());
    // deadline is longest travel time which is last element in sorted array
    int deadline = routeTravelTime[routes-1];
    // we require to minimize possible deadline after optionally removing one route so we always remove the longest route so that the new longest route is minimum
    // so the new deadlinne is second last element in sorted array 
    int newDeadline = routeTravelTime[routes-2];

    // according to qus it is optional to remove one route so we remove the longest route only if it helps in minimizing the deadline
    if(newDeadline < deadline)
    cout<<"The miimmum possible deadline after removing one route is : " <<newDeadline<<endl;
    else
    cout<<"The minimum possible deadline is : " <<deadline<<endl;

}