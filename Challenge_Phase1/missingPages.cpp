
#include<bits/stdc++.h>
using namespace std;
vector<string>missingPages(vector<int>&pages,int N){
    vector<string>ans;
    sort(pages.begin(), pages.end());
    
    int idx = 0;
    for(int i = 1; i <= N; i++){
        if(idx < pages.size() && pages[idx] == i){
            idx++;
        }
        else{
            int start = i;
            while(i <= N && (idx >= pages.size() || pages[idx] != i)){
                i++;
            }
            int end = i - 1;
            
            if(start == end){
                ans.push_back(to_string(start));
            }
            else{
                ans.push_back(to_string(start) + "-" + to_string(end));
            }
            i--;
        }
    }
    return ans;
}

int main(){
    int n, N; 
    cout << "Enter total pages (N): ";
    cin >> N;
    cout << "Enter number of pages found: ";
    cin >> n;
    vector<int> a(n);
    cout << "Enter the pages found: ";
    for(int i=0;i<n;i++) cin>>a[i];

    vector<string> ans = missingPages(a, N);
    cout << "Missing pages: ";
    for(int i = 0; i < ans.size(); i++){
        cout << ans[i];
        if(i < ans.size() - 1) cout << ", ";
    }
    cout << endl;
    return 0;
}