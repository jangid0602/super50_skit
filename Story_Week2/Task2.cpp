// @filename-task2.cpp
// @Description: This program is used to check continuous permutations
// @Author: Ayushi Shukla
#include<iostream>
#include<bits/stdc++.h>
#include<string>
using namespace std;
class Solution{
    public:
    bool checkPermutations(string subString, string superString){
        int n=superString.size();
        int m=subString.size();

        if(m>n){
            return false;
        }
        vector<int> subCount_frequency(128,0);
        vector<int> windowCount_frequency(128,0);

        for(char c: subString){
            subCount_frequency[(int)c]++;
        }
        for(int i=0;i<m;i++){
            windowCount_frequency[(int)superString[i]]++;
        }
        for(int i=0;i<n-m;i++){
            if(subCount_frequency==windowCount_frequency){
                return true;
            }
            if(i+m<n){
            windowCount_frequency[(int)superString[i+m]]++;
            windowCount_frequency[(int)superString[i]]--;
            }
        }
        return false;
    }
    };
int main(){
    string subString, superString;
    cout<<"Enter the super string : ";
    cin>>superString;
    cout<<"Enter the sub string : ";
    cin>>subString;
    Solution object;
    if(object.checkPermutations(subString,superString)){
        cout<<"Yes, the super string contains a permutation of the sub string"<<endl;
    }
    else{
        cout<<"No, the super string does not contain any permutation of the sub string"<<endl;
    }
}