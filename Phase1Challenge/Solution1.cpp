
#include <bits/stdc++.h>
using namespace std;
class Solution1
{
public:
Solution1(){}
    int longestdistance(vector<int> &arr, int k)
    {
        int current = 0, maximum = 0;
        for (int i = 0; i < arr.size() - 1; i++)
        {
            if (abs(arr[i] - arr[i + 1]) <= k)
            {
                current++;
                maximum = max(maximum, current);
            }
            else{
                current=0;
            }
        }
        if (abs(arr[arr.size() - 1] - arr[arr.size() - 2]) <= k)
        {
            current++;
            maximum = max(maximum, current);
        }
        return maximum;
    }
};
int main()
{
    Solution1 obj = Solution1();
    int n;
    cout << "enter size of array:";
    cin >> n;
    vector<int> arr(n);
    cout <<"enter array elements:"<<"\n";
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }
    int k;
    cout << "enter the value of constraint k:";
    cin >> k;
    cout << "the maximum reachacble distance is:" << obj.longestdistance(arr, k);
}