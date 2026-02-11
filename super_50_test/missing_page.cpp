#include<iostream>
#include<vector>
using namespace std;

vector<int> findmissingPage(vector<int> &ans,int N,int n){
   vector<int> finalans;
    for(int i=1;i<=N;i++){
        int flag = 0;
        for(int j = 0;j<n;j++){
            if(i == ans[j]){
                flag = 1;
            }
        }
        if(flag == 0){
            finalans.push_back(i);
        }
    }
    return finalans;
}

int main(){
    int N,n;
    cout<<"enter the no of pages(N) :";
    cin>>N;
    cout<<"enter the array size:";
    cin>>n;
    vector<int> ans(n);
    cout<<"enter the array elements:";
    for(int i=0;i<n;i++){
      cin>>ans[i];
    }
    cout<<"The array is:";
    for(int i=0;i<n;i++){
        cout<<ans[i]<<" ";
    }

    vector<int> arr ;
    arr = findmissingPage(ans,N,n);

    cout<<"Missing pages are:";
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<"  ";
    }
    return 0;
}