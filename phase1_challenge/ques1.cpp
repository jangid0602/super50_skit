#include<bits/stdc++.h>
using namespace std;
// heights = [1, 2, 5, 8], k = 3 → Output: 4 (Differences are 1, 3, 3; all $\le 3$)
// [10, 20, 22, 23, 30], k = 2 → Output: 3
class Solution{

    public:

    int longestStablePath(vector<int>&nums,int k){
        int n=nums.size();
        int maxPathLen=1;
        if(n==1) return 1;
        int l=0,r=0;
        while(r<n-1){
            if((nums[r+1]-nums[r])<=k){
                r++;
               maxPathLen= max(maxPathLen,r-l+1);
            }else{

                r++;
                l=r;
            }
        }

        return maxPathLen;
    }



};

int main(){

    Solution s1;
    vector<int>nums={5, 15, 25};
    int op=s1.longestStablePath(nums, 5);
    cout<<op;

return 0;
}