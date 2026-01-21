#include<bits/stdc++.h>
using namespace std;
int maxJump(vector<int> &heights,int k){
    int maxJump=0;
    int n=heights.size();
    vector<int>diff(n);
    diff[0]=0;
    for(int i=1;i<n;i++){
        diff[i]=heights[i]-heights[i-1];
    }   
    int cnt=0;
    for(int i=1;i<n;i++){
        if(diff[i]<=k){
            cnt++;
            maxJump=max(maxJump,cnt);
        }
        else{
            cnt=0;
        }
    }
    return maxJump;
}

int main(){
    int n;
    int k;
    cout<<"Enter size of array and jump difference:";
    cin>>n;
    cin>>k;
    vector<int> arr(n);

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    sort(arr.begin(),arr.end());
    int result=maxJump(arr,k);
    cout<<"The maxJump length is:"<<result;
    return 0;
}