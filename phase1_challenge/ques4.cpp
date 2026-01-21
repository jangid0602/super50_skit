#include<bits/stdc++.h>
using namespace std;

// Mirror pairs: (b,d), (p,q), (s,s), (x,x), (z,z), (o,o).
// Input: "bod" → Output: true ('b' mirrors 'd', 'o' mirrors 'o') 
// 2. Input: "pq" → Output: true ('p' mirrors 'q') 
// 3. Input: "abc" → Output: false ('a' has no mirror)

class Solution{
    unordered_map<char,char>mirrorPair={{'b','d'},{'p','q'},{'s','s'},{'x','x'},{'z','z'},{'o','o'}};
   public:

    bool mirrorWord(string word){

        int n =word.size()-1;
        // cout<<"a";
        return checkMirrorWord(word,0,n);
       

    }

    bool checkMirrorWord(string word,int l,int r){
        if(l==r) return true;

       if(mirrorPair[word[l]]==word[r]){
        return checkMirrorWord(word,l++,r--);
       }
        return false;
       
    }



};

int main(){

    Solution s1;
    string word1="abc";
    string word2="pq";

    cout<<s1.mirrorWord(word1);
    cout<<endl;
    cout<<s1.mirrorWord(word2);

    return 0;


return 0;
}