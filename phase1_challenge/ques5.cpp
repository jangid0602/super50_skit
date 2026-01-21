// Oxygen Tank Scrubber



#include<bits/stdc++.h>
using namespace std;

// Input: s = "aAbBcC" → Output: "" (All pairs react) 2. Input: s = "ABbC" → Output: "AC" ('B' and 'b' react) 3. Input: s = "sSttaA" → Output: "tt"

class Solution{
    
   public:

    string oxygenTankScrubber(string word){

        int r=0;
        int n =word.size();
        set<char>sm;
        set<char>up;
        for(int ch='a';ch<='z';ch++) sm.insert(ch);
        for(int ch='A';ch<='Z';ch++) up.insert(ch);

        string ans="";

        while(r<n-1){
            if(sm.find(word[r])!=sm.end() && up.find(word[r+1])!=up.end()){
                r+=2;

            }else if(up.find(word[r])!=up.end() && sm.find(word[r+1])!=sm.end()){
                r+=2;
            }else{
                ans+=word[r];
                r++;
            }

        }
        if(r==n-1) ans+=word[r];

        return ans;
        

    }





};

int main(){

    Solution s1;
    string word1="aAbBcC";
    string word2="ABbC";
    string word3="sSttaA";

    cout<<s1.oxygenTankScrubber(word1);
    cout<<endl;
    cout<<s1.oxygenTankScrubber(word2);
    cout<<endl;
    cout<<s1.oxygenTankScrubber(word3);


   

    return 0;


return 0;
}