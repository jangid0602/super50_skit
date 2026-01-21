/*1. The floor is Lava*/

#include <iostream>
#include <vector>
using namespace std;

int longestStablePath(vector<int>& heights, int k){
    int longestLength = 1;
    int currentLength = 1;

    for (int i = 0 ; i < heights.size()-1 ; i++){
    	//can go down?
        if (abs(heights[i+1] - heights[i]) <= k){
            currentLength++;
        } 
		else{
            currentLength = 1;
        }
        longestLength = max(longestLength, currentLength);
    }
    return longestLength;
}

int main(){
    vector<int> heights = {1, 2, 5, 8};
    int k = 3;

    cout << longestStablePath(heights, k);
    return 0;
}

