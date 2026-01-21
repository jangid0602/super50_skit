#include <bits/stdc++.h>
using namespace std;
class Solution3
{   
    public:
    bool isPalindrome(string s){
        for(int i=0;i<s.length();i++){
            if(s[i]=='a'){
                s[i]='e';
            }
            else if(s[i]=='e'){
                s[i]='i';
            }
            else if(s[i]=='i'){
                s[i]='o';
            }
            else if(s[i]=='o'){
                s[i]='u';
            }
            else if(s[i]=='u'){
                s[i]='a';
            }
        }
        int left=0,right=s.length()-1;
        while(left<=right){
            if(s[left]!=s[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
};
int main(){
    Solution3 obj =Solution3();
    string s;
    cout <<"enter string:";
    cin >>s;
    if(obj.isPalindrome(s)){
        cout <<"true";
    }
    else{
        cout <<"false";
    }
}