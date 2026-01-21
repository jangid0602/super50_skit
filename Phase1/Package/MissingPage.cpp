#include <bits/stdc++.h>
using namespace std;
vector<string> findMissing(vector<int> &pages, int n)
{
    vector<string> ans;
    ordered_map<int,int> freq;
    int size = pages.size();
    if (size == 1 && pages[0] == n && n != 1)
    {
        ans.push_back("1-" + to_string(n - 1));
        return ans;
    }
    

    for (int i = 0; i < n; i++)
    {
        freq[i + 1] = 1;
    }

    for (int i = 0; i < size; i++)
    {
        if (freq.find(pages[i]) != freq.end())
        {
            freq.erase(pages[i]);
        }
    }
    for (auto it = freq.begin(); it != freq.end();)
    {
        int start = it->first;
        int end = start;
        auto nextIt = next(it);
        while (nextIt != freq.end() && nextIt->first == end + 1)
        {
            end = nextIt->first;
            nextIt = next(nextIt);
        }
        if (start == end)
        {
            ans.push_back(to_string(start));
        }
        else
        {
            ans.push_back(to_string(start) + "-" + to_string(end));
        }
        it = nextIt;
    }
}
int main()
{
    vector<int> pages = {2, 3, 9};
    int n = 10;
    findMissing(pages, n);

    return 0;
}