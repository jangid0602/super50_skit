#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution{
    public :
    string CandyCrush(string word)
    {
        string ans="";
        stack<char>st;
        int n=word.size();
        for(int i=0;i<n;i++)
        {
            if(!st.empty() && ((st.top()+32)==word[i] ||(st.top()-32)==word[i]))
            {
                st.pop();
                
            }
            else
            st.push(word[i]);
        }
        while(!st.empty())
        {
            ans.push_back(st.top());
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};

int main()
{
    Solution solution;
    string inputString;
    cout<<"Enter the input String:";
    cin>>inputString;
    string result=solution.CandyCrush(inputString);
    cout<<"The output will be:";
    if(result.size()==0)
    cout<<"Empty String"<<endl;
    else
    cout<<result<<endl;
    return 0;
}