#include <bits/stdc++.h>
using namespace std;

int main() {
	cout<<"enter no of test cases\n";
    int t;
    cin>>t;
    while(t--){
        int n;
        cout<<"enter size of array---\n";
        cin>>n;
        vector<int> v;
        cout<<"enter elements:- \n";
        for(int i=0;i<n;i++){
            int e;
            cin>>e;
            v.push_back(e);
        }
        cout<<"enter total no of pages N\n";
        int N;
        cin>>N;
        sort(v.begin(),v.end());
        int last=1;
        cout<<"missing pages are::\n";
        for(int i=0;i<n;i++){
            if(last<v[i]){
                if(abs(last-v[i])>1)
                    cout<<last<<"-"<<v[i]-1<<"\n";
                else
                    cout<<last<<"\n";
                last=v[i]+1;
            }else if(last==v[i]){
                last=v[i]+1;
            }
        }
        if(N-last+1>0){
            if(N-last>1)
            cout<<last<<"-"<<N<<"\n";
            else{
                cout<<N<<"\n";
            }
        }

    }

}
