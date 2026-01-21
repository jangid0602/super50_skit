#include<bits/stdc++.h>
#include<iostream>
using namespace std;

bool solve(string s){
    vector<vector<char>>a {{"a","e"},{"e","i"},{"i","o"},{"o","u"},{"u","a"}};
    unordered_map<char,char>mp;
    for(auto i : a){
        mp[i[0]] = i[1];
    }
    for(int i = 0 ; i < s.length() ; i++){
        if(mp.find(s[i]) != mp.end()){
            s[i] = mp[s[i]];
        }
    }
    int i = 0 , j = s.length()-1;
    while(i<=j){
        if(s[i] == s[j]){
            i--,j++;
        }
        else return false;
    }
    return true;
}