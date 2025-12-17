/**
 * @filename - Story4.cpp
 * @description -  THE Spy's Cipher
 * @author - Fatimi Bee
 */
#include<iostream>
#include<vector>
#include<string>
#include<map>
using namespace std;

int main(){
    string original,scrambled;
    cout<<"Enter the original messsage: ";
    getline(cin,original);

    cout<<"Enter the scrambled message: ";
    getline(cin,scrambled);

    map<char,int>originalCount;
    for(char c : original){
        originalCount[c]++;
    }

    for(char c: scrambled){
        originalCount[c]--;
        if(originalCount[c]==0) originalCount.erase(c);
    }
    if(originalCount.empty()){
        cout<<"The message is not scrambeled."<<endl;
    }
    else{
        cout<<"The message is scrambled by addinng chracters:";
        for(auto pair:originalCount){
            cout<<pair.first<<" ";
        }
    }
}