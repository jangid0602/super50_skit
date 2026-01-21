#include <bits/stdc++.h>
using namespace std;
class Solution4{
    public: 
    unordered_map<char,char>um={
        {'p','q'},
        {'q','p'},
        {'b','d'},
        {'d','b'},
        {'s','s'},
        {'x','x'},
        {'z','z'},
        {'o','o'}
    };
    bool countMirrorPairs(string arr){
        if(arr.empty()){
            return false;
        }
       return calc(arr,0,arr.size()-1);

   
    }
    bool calc(string&arr,int i,int j){
        if(j-i<=1){
            
            return true;
        }
        if(isMirror(arr[i],arr[j])){
            return true;
        }
        return false;
    }
    bool isMirror(char a,char b){
         if(um.find(a)!=um.end() && um[a]==b){
             return true;
         }  
         return false;
    }
};
int main(){
    Solution4 obj=Solution4();
   string s;
   cout <<"enter a string:";
   cin >> s;
    if(obj.countMirrorPairs(s)){
         cout <<"true";
    }
    else{
         cout <<"false";
    }   
  

}