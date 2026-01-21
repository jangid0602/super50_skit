#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int Floor_is_Lava(vector<int> &arr,int k)
{
    int n=arr.size();
    int currlength=1;
    int maxlength=1;
    for(int i=0;i<n-1;i++)
    {
        if(abs(arr[i+1]-arr[i])<=k)
        currlength++;
        else
        currlength=1;
        maxlength=max(maxlength,currlength);
    }
    return maxlength;

}
int main()
{
    vector<int> arr={1, 2, 5, 8};
    int k=3;
    int result=Floor_is_Lava(arr,k);
    cout<<"Longest Stable Path is :"<<result;
}