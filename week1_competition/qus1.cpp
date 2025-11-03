/**
 * @filename - qus1.cpp
 * @Set - B
 * @description - The Time Traveler’s Array
 * @author - Fatimi Bee 
 */
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int subarraysum(vector<int>& arr , int target){
  unordered_map<int,int> prefixsumcount;
  prefixsumcount[0]=1;
  int prefixsum=0;
  int count=0;
  for(int num: arr ){
    prefixsum+=num;
    int complement = prefixsum - target;
    if(prefixsumcount.find(complement) != prefixsumcount.end()){
        count += prefixsumcount[complement];
    }
    prefixsumcount[prefixsum]++;
  }
  return count;
}

int main(){
    int n, target;
    cout<<"Enter number of elements and target sum: ";
    cin>>n>>target;
    vector<int>arr(n);
    cout<<"Enter elements : ";
    for(int i=0;i<n ;i++){
        cin>>arr[i];
    }
    cout<<"Result : "<<subarraysum(arr,target)<<endl;
}