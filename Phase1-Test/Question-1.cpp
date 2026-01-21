#include<iostream>
using namespace std;
int main(){
    int n,k;

    cout<<"enter the size of array : ";
    cin>>n;

    cout<<"enter the k  : ";
    cin>>k;

    int arr[n];
    cout<<"enter the array (sorted) : ";

    for(int i=0; i<n; i++) cin>>arr[i];

    int longestSubArray = 1;

    for(int i=0; i<n; i++){
        if(arr[i+1] - arr[i] <= k && i<n) longestSubArray++;
    }
    cout<<longestSubArray;
    return 0;
}