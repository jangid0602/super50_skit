#include <bits/stdc++.h>
using namespace std;

int main(){
    cout<<"enter no of test cases\n";
    int t;
    cin>>t;
    while(t--){
        vector<int> heights;
        int sizeOfHeight;
        cout<<"enter size of array:--\n";
        cin>>sizeOfHeight;
        cout<<"enter elements:--\n";
        for(int i=0;i<sizeOfHeight;i++){
            int e;
            
            cin>>e;

            heights.push_back(e);
        }
        cout<<"enter value of k:--\n";
        int k;
        cin>>k;
        int streak=1;
        int ans=1;
        for(int i=0;i<sizeOfHeight-1;i++){
            if(heights[i]-heights[i+1]<=k){
                streak++;
                ans=max(ans,streak);
            }else{
                streak=1;
            }
        }
        cout<<"output-"<<ans<<"\n";
    }
}