//  The Floor is Lava 

#include<iostream>
#include<vector>
using namespace std;
class Solution {
    public:
    int maxstablepath(vector<int>&heights,int k){
    int maxstreak=1;
    int currentstreak=1;
    for(int i=0;i<heights.size();i++){
        if(abs(heights[i]-heights[i+1])<=k){
            currentstreak++;
            maxstreak=max(maxstreak,currentstreak);
        }
        else{
            currentstreak=1;
        }
    }
    return maxstreak;
}
};

int main(){
    int size;
    cout<<"Enter the number of heights:";
    cin>>size;
    vector<int>heights(size);
    for(int i=0;i<size;i++){
        cout<<"Enter height at index "<<i<<":";
        cin>>heights[i];
    }
    int k;
    cout<<"Enter the maximum jump allowed (k):";
    cin>>k;
    Solution sol;
    int maxstreak= sol.maxstablepath(heights,k);
    cout<<"The longest stable path has length:"<<maxstreak<<endl;
}