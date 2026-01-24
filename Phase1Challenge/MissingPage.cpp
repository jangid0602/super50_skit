#include<bits/stdc++.h>
using namespace std;

int main(){
    vector<int>pages={2,3,9};
    int n=pages.size();
    int N=10;
    set<int>st;
    for(int i=0;i<n;i++){
        st.insert(pages[i]);
    }
    
    queue<int>q;
    for(int i=1;i<=N;i++){
        if(st.find(i)==st.end()){
            q.push(i);
        }
        else{
            if(q.size()==0) continue;
            else if(q.size()==1) cout<<q.front()<<" ";
            else cout<<q.front()<<'-'<<q.back()<<" ";
            while(!q.empty()){
                q.pop();
            }
        }
    }
    
    if(q.size()==1) cout<<q.front()<<" ";
    else cout<<q.front()<<'-'<<q.back()<<" ";
}