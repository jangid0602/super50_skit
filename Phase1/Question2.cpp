#include<iostream>
#include<bits/stdc++.h>
using namespace std;

class Solution{
    public :
    vector<string> MissingPageNumber(vector<int>&pages,int NtotalPages)
    {
        vector<string>ans;
        unordered_set<int>s;
        for(int i=0;i<pages.size();i++)
        {
            s.insert(pages[i]);
        }
        for(int i=1;i<=NtotalPages;i++)
        {
            if(s.find(i)==s.end())
            {
                ans.push_back(to_string(i));
            }
        }
        return ans;

    }
};

int main()
{
    int NtotalPages;
    cout<<"Enter the total number of pages in the book:";
    cin>>NtotalPages;
    int n;
    cout<<"Enter the number of pages given:";
    cin>>n;
    vector<int>pages;
    Solution solution;
    for(int i=0;i<n;i++)
    {
        int page;
        cout<<"Enter the page number:";
        cin>>page;
        pages.push_back(page);
    }
    vector<string>ans=solution.MissingPageNumber(pages,NtotalPages);
    for(auto x:ans)
    {
        cout<<x<<", ";
    }
    return 0;
}