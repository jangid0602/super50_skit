/**
 * @filename - story1.cpp
 * @description - The Trendsetter Score
 * @author - Fatimi Bee 
 */

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int TrendsetterScore(vector<int>& post, int windowSize){
    unordered_map<int,int> freq;
    int score=0;
    int left=0;
    for(int right=0 ; right <post.size() ;right++ ){
        freq[post[right]]++;
        

        if(right - left +1 > windowSize){
            freq[post[left]]--;
            if(freq[post[left]]==0){
                freq.erase(post[left]);
            }
            left++;
        }

        if (right - left + 1 == windowSize) {
            int maxFreq = 0;
            int countMax = 0;

            
            for (auto &p : freq) {
                if (p.second > maxFreq) {
                    maxFreq = p.second;
                    countMax = 1;
                } else if (p.second == maxFreq) {
                    countMax++;
                }
            }

            //  If exactly one element has max frequency → it's a trendsetter
            if (countMax == 1)
                score++;
        }
    }
    return score;

}

int main(){
    int n, k;
    cout<<"Enter number of posts and window size : ";
    cin>>n>>k;
    vector<int>posts(n);
    cout<<"Enter the posts :";
    for(int i=0; i<n ;i++){
        cin>>posts[i];
    }
    int result = TrendsetterScore(posts,k);
    cout<<"Trendsetter Score : "<<result<<endl;
}