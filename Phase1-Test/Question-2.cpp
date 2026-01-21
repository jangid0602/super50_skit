#include<iostream>
#include<vector>
using namespace std;
int main(){
    int n,N;

    cout<<"enter the size of array : ";
    cin>>n;

    cout<<"enter the N  : ";
    cin>>N;

    int arr[n];
    cout<<"enter the array : ";

    for(int i=0; i<n; i++) cin>>arr[i];

    vector<string> missingPages;

    for(int i=0; i<n; i++){
        if(arr[i+1]-arr[i] > 1) 
        missingPages.push_back(arr[i]+1+"-"+arr[i+1]+1);
    return 0;
}