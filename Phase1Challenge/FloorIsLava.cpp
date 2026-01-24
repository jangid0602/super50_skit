#include<bits/stdc++.h>
using namespace std;

int main(){
    vector<int>heights={10,20,22,23,30};
    int k=2;
    int n=heights.size();
    int diff[n-1];
    for(int i=0;i<n-1;i++){
        diff[i]=heights[i+1]-heights[i];
    }
    int cnt=0;
    int maxc=-1;
    
    for(int i=0;i<n-1;i++){
        if(diff[i]>k){
            cnt=0;
        }
        else{
            cnt++;
        }
        maxc=max(maxc,cnt);
    }
   if(maxc==0) cout<<-1;
    else cout<<maxc+1;
}