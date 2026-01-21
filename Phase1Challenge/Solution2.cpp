#include <bits/stdc++.h>
using namespace std;
class Solution2{
    public:
    vector<string> findMissingNumbers(vector<int>&arr,int N){
        int low=1,high=1;
        unordered_map<int,int>um;
        vector<string>ans;
        for(auto x:arr){
            um[x]++;
        }
         while(high<=N){
            if(um.find(high)!=um.end()){

                high++;
                low=high;
            }
            else{
                while(um.find(high)==um.end()&&high<=N){
                    high++;
                }
                if(high-1==low){
                    ans.push_back(to_string(high-1));
                    low=high;
                }
                else{
                    ans.push_back(to_string(low)+"-"+to_string(high-1));
                    low=high;
                }
            }

        }
        return ans;
    }
};
    int main(){
        Solution2 obj=Solution2();
        int n;
        cout <<"enter size of array:";
        cin >>n;
        vector<int>arr(n);
        cout <<"enter array elements:"<<"\n";
        for(int i=0;i<n;i++){
            cin >>arr[i];
        }
        int N;
        cout <<"enter the range of elements i.e N";
        cin >>N;
        vector<string>ans=obj.findMissingNumbers(arr,N);
        for(int i=0;i<ans.size();i++){
            cout <<ans[i]<<" ";
        }
      
    }
