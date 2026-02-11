#include <bits/stdc++.h>
using namespace std;

/* ---------- 1. Startup Revenue Maxima ---------- */
void startupRevenue() {
    int n;
    cout << "Enter N: ";
    cin >> n;

    vector<long long> a(n+1);
    cout << "Enter revenues: ";
    for(int i=1;i<=n;i++) cin >> a[i];

    vector<long long> dp(n+1,0);
    dp[1] = a[1];

    for(int i=2;i<=n;i++){
        long long val = a[i];
        if(i % 7 == 0) val *= 2;
        dp[i] = max(dp[i-1], dp[i-2] + val);
    }

    cout << "Max Revenue = " << dp[n] << endl;
}

/* ---------- 2. Mentorship Matching ---------- */
void mentorshipMatching() {
    int n;
    cout << "Enter N: ";
    cin >> n;

    vector<vector<int>> s(n, vector<int>(n));
    cout << "Enter matrix:\n";
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            cin >> s[i][j];

    int size = 1<<n;
    vector<int> dp(size, -1);
    dp[0]=0;

    for(int mask=0;mask<size;mask++){
        int i = __builtin_popcount(mask);
        for(int j=0;j<n;j++){
            if(!(mask&(1<<j))){
                dp[mask|(1<<j)] = max(dp[mask|(1<<j)], dp[mask] + s[i][j]);
            }
        }
    }

    cout << "Max Compatibility = " << dp[size-1] << endl;
}

/* ---------- 3. Tech Stack Swap ---------- */
void techStackSwap() {
    string a,b;
    int ci,cd,cu;
    cout<<"Enter S1: "; cin>>a;
    cout<<"Enter S2: "; cin>>b;
    cout<<"Enter Insert, Delete, Update cost: ";
    cin>>ci>>cd>>cu;

    int n=a.size(), m=b.size();
    vector<vector<int>> dp(n+1, vector<int>(m+1));

    for(int i=0;i<=n;i++) dp[i][0]=i*cd;
    for(int j=0;j<=m;j++) dp[0][j]=j*ci;

    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(a[i-1]==b[j-1]) dp[i][j]=dp[i-1][j-1];
            else{
                dp[i][j]=min({dp[i-1][j]+cd,
                              dp[i][j-1]+ci,
                              dp[i-1][j-1]+cu});
            }
        }
    }

    cout<<"Min Cost = "<<dp[n][m]<<endl;
}

/* ---------- 4. Placement Marathon ---------- */
void placementMarathon() {
    int n,k;
    cout<<"Enter N and K: ";
    cin>>n>>k;

    vector<int>a(n);
    cout<<"Enter array: ";
    for(int i=0;i<n;i++) cin>>a[i];

    unordered_map<int,int> dp;
    int ans=1;

    for(int x:a){
        int v1 = dp[x-k];
        int v2 = dp[x+k];
        dp[x]=max(dp[x], max(v1,v2)+1);
        ans=max(ans,dp[x]);
    }

    cout<<"Longest Length = "<<ans<<endl;
}

/* ---------- 5. Optimal Server Latency ---------- */
void optimalServerLatency() {
    int n,k;
    cout<<"Enter N and K: ";
    cin>>n>>k;

    vector<int>a(n+1);
    cout<<"Enter powers: ";
    for(int i=1;i<=n;i++) cin>>a[i];

    const int INF=1e9;
    vector<vector<int>> dp(k+1, vector<int>(n+1,INF));

    for(int i=1;i<=n;i++){
        int mn=a[i], mx=a[i];
        for(int j=i;j<=n;j++){
            mn=min(mn,a[j]);
            mx=max(mx,a[j]);
            dp[1][j]=mx-mn;
        }
    }

    for(int i=2;i<=k;i++){
        for(int j=i;j<=n;j++){
            int mn=a[j], mx=a[j];
            for(int p=j;p>=i;p--){
                mn=min(mn,a[p]);
                mx=max(mx,a[p]);
                dp[i][j]=min(dp[i][j], dp[i-1][p-1]+(mx-mn));
            }
        }
    }

    cout<<"Min Unbalance = "<<dp[k][n]<<endl;
}

/* ---------- 6. Ad Placement ---------- */
void adPlacement() {
    int T,m;
    cout<<"Enter T and M: ";
    cin>>T>>m;

    vector<int>d(m),p(m);
    cout<<"Enter duration and profit:\n";
    for(int i=0;i<m;i++) cin>>d[i]>>p[i];

    vector<int> dp(T+1,0);

    for(int i=0;i<m;i++){
        for(int t=T;t>=d[i];t--){
            dp[t]=max(dp[t], dp[t-d[i]]+p[i]);
            if(t>=2*d[i])
                dp[t]=max(dp[t], dp[t-2*d[i]] + p[i] + p[i]/2);
        }
    }

    cout<<"Max Profit = "<<dp[T]<<endl;
}

/* ---------- MAIN MENU ---------- */
int main(){
    while(true){
        cout<<"\n====== MENU ======\n";
        cout<<"1. Startup Revenue\n";
        cout<<"2. Mentorship Matching\n";
        cout<<"3. Tech Stack Swap\n";
        cout<<"4. Placement Marathon\n";
        cout<<"5. Optimal Server Latency\n";
        cout<<"6. Ad Placement\n";
        cout<<"0. Exit\n";
        cout<<"Enter choice: ";

        int ch;
        cin>>ch;

        switch(ch){
            case 1: startupRevenue(); break;
            case 2: mentorshipMatching(); break;
            case 3: techStackSwap(); break;
            case 4: placementMarathon(); break;
            case 5: optimalServerLatency(); break;
            case 6: adPlacement(); break;
            case 0: return 0;
            default: cout<<"Invalid Choice\n";
        }
    }
}

