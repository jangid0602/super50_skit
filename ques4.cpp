#include<bits/stdc++.h>
#include<iostream>
using namespace std;

bool isValid(string s,unordered_map<char,char>&mp){
    int i = 0 , j = s.size() -1;
    while(i<=j){
        if(mp[s[i]] == s[j] || mp[s[j]] == s[i]){
            i++;
            j--;
        }
        else return false;
    }
    return true;
}
int main(){
    int tst;
    cin>>tst;
    while(tst--){
        int n;;
        cin>>n;
        string input;
        cin>>input;
        vector<vector<char>>arr(n);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 2;j++){
                cin>>arr[i][j];
            }
        }
        unordered_map<char,char>mp;
        for(auto i : arr){
            mp[i[0]] = i[1];
            mp[i[1]] = i[0];
        }
        cout<<isValid(input,mp);
    }
    return 0;
}