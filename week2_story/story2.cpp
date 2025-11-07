/**
 * @filename - story2.cpp
 * @description - Encoded String Subsets
 * @author - Fatimi Bee 
 */

 #include<iostream>
 #include<bits/stdc++.h>
 using namespace std;

 bool isSubsetEncoded(string &superstring , string &substring)
 {
    unordered_map<char ,int> subfrequency;
    for(char ch : substring){
        subfrequency[ch]++;
    }
    int window=substring.size();
    unordered_map<char,int> windowfrequency;

    int left =0;
    for(int right =0 ; right < superstring.size() ;right++){
        windowfrequency[superstring[right]]++;
        if(right - left +1 > window){
            windowfrequency[superstring[left]]--;
            if(windowfrequency[superstring[left]]==0){
                windowfrequency.erase(superstring[left]);
            }
            left++;
        }
        if(right - left  +1 == window){
            bool match = true;
            for(auto &p : windowfrequency){
                if(subfrequency.find(p.first) == subfrequency.end() || subfrequency[p.first] < p.second){
                    match=false;
                    break;
                }

            }
            if(match) return true;
        }
    }
    
    return false;
 }

 int main(){
    string superstring, substring;
    cout<<"Enter the superstring :";
    cin>>superstring;
    cout<<"Enter the substring :";
    cin>>substring;
    cout<<"Is the substring encoded in superstring ? : "<<(isSubsetEncoded(superstring,substring) ? "True" : "False");
 }