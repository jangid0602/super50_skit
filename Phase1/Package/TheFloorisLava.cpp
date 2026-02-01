   #include <bits/stdc++.h>
   using namespace std;
    int lava(vector<int> heights, int k){
    int left=0;
    int right=0;
    int size=0;
    int maxSize=0;
    int n=heights.size();
    while(right<n)
    {
        int diff=heights[right]-heights[left];
        if(diff<=k)
        {
            size=right-left+1;
            maxSize=max(size,maxSize);
            right++;
        }
        else{
            left++;
        }

    }
    return maxSize==1?1:maxSize+1;
    }
    int main(){
        vector<int> heights={5,15,25};
        int k=10;
        cout<<lava(heights,k);
        return 0;
    }
   


