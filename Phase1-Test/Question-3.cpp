#include<iostream>
#include<string>
using namespace std;

 bool checkPalindrome(string ans,int n){
     int e = n-1;
     int s = 0;
     while (s<e){
         if(ans[s] != ans[e]){
             return false;
         }
         s++;
         e--;
     }
     return true;
 }

int main(){
    string input;

    cout<<"enter the string : ";
    cin>>input;

    int n = input.size();
	string ans;

    for(int i=0; i<n; i++){
        if(input[i] == 'a') ans.push_back('e');
        else if(input[i] == 'e') ans.push_back('i');
        else if(input[i] == 'i') ans.push_back('o');
        else if(input[i] == 'o') ans.push_back('u');
        else if(input[i] == 'u') ans.push_back('a');
        else ans.push_back(input[i]);
    }

    bool isPalindrome = checkPalindrome(ans,n);
    cout<<isPalindrome;
    return 0;
}