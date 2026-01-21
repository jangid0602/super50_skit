#include<bits/stdc++.h>
using namespace std;
int lavaFloor(vector<int> heights,int k){
    int cnt=1;
    int ans=1;
    for(int i=0;i<heights.size()-1;i++){
        if(heights[i+1]-heights[i]<=k) cnt++;
        else{
            ans=max(ans,cnt);
            cnt=1;
        }
    }
    ans=max(ans,cnt);
    return ans;
}
int main(){
    vector<int> heights={5,10,15,20,23,30};
    int k=5;
    cout<<"Output:"<<lavaFloor(heights,k);
    return 0;
}