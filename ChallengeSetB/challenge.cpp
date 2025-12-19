#include <iostream>
#include<bits/stdc++.h>
#include <vector>
using namespace std;


int subArraysWithSumK(vector<int>&arr,int target){
    unordered_map<int, int> prefixCount;
    int currentSum = 0, count = 0;

    for (int num : arr) {
        currentSum += num;
        if (prefixCount.find(currentSum - target) != prefixCount.end()) {
            count += prefixCount[currentSum - target];
        }

        prefixCount[currentSum]++;
    }

    return count;
}

string cipherShift(string str,int k){
    string result="";
    for(char c:str){
        if(isalpha(c)){
            char base=islower(c)?'a':'A';
            char shifted= (c - base + k)%26 + base;
            result+=shifted;
        }else{
            result+=c;
        }
    }
    return result;
}


int main(){
    
    int ch;
    cout << "Enter your problem (1-3): ";
    cin >> ch;
    switch(ch){
        case 1: {
            cout << "The Time traveller array problem" << endl;
            int n,k;
            cout<<"Enter the size of the array and the target sum: ";
            cin>>n>>k;
            vector<int>arr(n);
            for(int i=0;i<n;i++){
                cin>>arr[i];    
            }
            int ans=subArraysWithSumK(arr,k);
            cout <<"The number of subarrays with sum " << k << " is: " << ans << endl;
            break;
        }
        case 2: {
            cout << "The Shifted Cipher Problem" << endl;
            int l;
            cout<<"Enter the shift value";
            cin>>l;
            string input;
            cout<<"Enter the string to be encrypted: ";
            cin>>input;
            string encrypted = cipherShift(input, l);
            cout << encrypted << endl;
            break;
        }
        case 3: {
            exit(0);
            cout << "" << endl;
            break;
        }
        default: {
            cout << "Default case selected" << endl;
        }
    }


    return 0;


}