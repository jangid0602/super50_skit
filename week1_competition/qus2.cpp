/**
 * @filename - qus2.cpp
 * @Set - B
 * @description - The Shifting Cipher
 * @author - Fatimi Bee 
 */

#include<iostream>
#include<bits/stdc++.h>
using namespace std;
string shiftString(string &s , int k){
    string result = "";
    for(char ch :s){
        if(isalpha(ch)){
            char base = islower(ch) ? 'a' : 'A';
            char shifted =(ch - base + k) %26 +base;
            result +=shifted;
        }
        else{
            result+=ch;
        }
    }
    return result;
}
int main(){
    string s;
    int k;
    cout<<"Enter the string : ";
    getline(cin,s);
    cout<<"Enter the shifted value:";
    cin>>k;
    string result = shiftString(s,k);
    cout<<"Result :" <<result<<endl;

}