#include<bits/stdc++.h>
using namespace std;

// mapping a→e, e→i, i→o, o→u, u→a.
// s = "ebba" → Output: true (
class Solution{
    unordered_map<char,char>mp={{'a','e'},{'e','i'},{'i','o'},{'o','u'},{'u','a'}};
   public:

    bool encryptedPalindrome(string word){

        for(int i=0;i<word.size();i++){
                if(mp.find(word[i])!=mp.end()){
                        word[i]=mp[word[i]];
                }
        }

        int l=0,r=word.size()-1;

        while(l<r){
            if(word[l]!=word[r]){
                return false;
            }else{
                r--,l++;
            }
        }
        return true;

    }



};

int main(){

    Solution s1;
    string word1="ace";
    string word2="vutuv";

    cout<<s1.encryptedPalindrome(word2);

    return 0;


return 0;
}