

#include<bits/stdc++.h>
#include<iostream>
using namespace std;
int main(){
    int tst;
    cin>>tst;
    while(tst--){
        int n,k;
        cin>>n>>k;
        vector<int>arr(n);
        for(int i = 0 ; i < n ; i++) cin >>arr[i];
        int count = 1;
        int ans = INT_MIN;
        for(int i = 1;i<n;i++){
            if(arr[i] - arr[i-1] <= k)count++;
            else count = 1;
            ans = max(ans,count);
        }
        cout<< ans << endl;

    }
    return 0;
}