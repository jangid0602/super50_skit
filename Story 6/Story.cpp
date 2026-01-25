#include <bits/stdc++.h>
using namespace std;

/* ================= PROBLEM 1 ================= */
int cheapestFlight(int n, vector<vector<int>>& flights, int src, int dst, int k) {
    vector<vector<pair<int,int>>> adj(n);
    for (auto &f : flights)
        adj[f[0]].push_back({f[1], f[2]});

    queue<pair<int,int>> q;
    q.push({src, 0});
    vector<int> dist(n, INT_MAX);
    dist[src] = 0;

    int stops = 0;
    while (!q.empty() && stops <= k) {
        int sz = q.size();
        while (sz--) {
            pair<int,int> p = q.front(); q.pop();
            int u = p.first;
            int cost = p.second;

            for (auto &v : adj[u]) {
                if (cost + v.second < dist[v.first]) {
                    dist[v.first] = cost + v.second;
                    q.push({v.first, dist[v.first]});
                }
            }
        }
        stops++;
    }
    return dist[dst] == INT_MAX ? -1 : dist[dst];
}

/* ================= PROBLEM 2 ================= */
int safestPath(int n, vector<vector<int>>& edges, int start, int end) {
    vector<vector<pair<int,int>>> adj(n);
    for (auto &e : edges) {
        adj[e[0]].push_back({e[1], e[2]});
        adj[e[1]].push_back({e[0], e[2]});
    }

    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    vector<int> risk(n, INT_MAX);
    pq.push({0, start});
    risk[start] = 0;

    while (!pq.empty()) {
        pair<int,int> p = pq.top(); pq.pop();
        int r = p.first, u = p.second;

        if (u == end) return r;

        for (auto &v : adj[u]) {
            int newRisk = max(r, v.second);
            if (newRisk < risk[v.first]) {
                risk[v.first] = newRisk;
                pq.push({newRisk, v.first});
            }
        }
    }
    return -1;
}

/* ================= PROBLEM 3 ================= */
int minTimeTasks(vector<int>& time, vector<vector<int>>& edges) {
    int n = time.size();
    vector<vector<int>> adj(n);
    vector<int> indeg(n,0);

    for (auto &e : edges) {
        adj[e[0]].push_back(e[1]);
        indeg[e[1]]++;
    }

    queue<int> q;
    vector<int> dp = time;

    for (int i=0;i<n;i++)
        if (indeg[i]==0) q.push(i);

    while (!q.empty()) {
        int u=q.front(); q.pop();
        for (int v: adj[u]) {
            dp[v] = max(dp[v], dp[u] + time[v]);
            if (--indeg[v]==0) q.push(v);
        }
    }
    return *max_element(dp.begin(), dp.end());
}

/* ================= PROBLEM 4 ================= */
vector<int> dijkstraMatrix(vector<vector<int>>& mat, int src) {
    int n = mat.size();
    vector<int> dist(n, INT_MAX);
    vector<bool> vis(n,false);
    dist[src]=0;

    for(int i=0;i<n;i++){
        int u=-1;
        for(int j=0;j<n;j++)
            if(!vis[j] && (u==-1 || dist[j]<dist[u])) u=j;

        if(u==-1) break;   // FIX
        vis[u]=true;

        for(int v=0;v<n;v++){
            if(mat[u][v]!=0 && dist[u]+mat[u][v]<dist[v])
                dist[v]=dist[u]+mat[u][v];
        }
    }
    return dist;
}

/* ================= PROBLEM 5 ================= */
vector<int> kNearest(int n, vector<vector<int>>& edges, int s, int k) {
    vector<vector<pair<int,int>>> adj(n);
    for(auto &e:edges){
        adj[e[0]].push_back({e[1],e[2]});
        adj[e[1]].push_back({e[0],e[2]});
    }

    vector<int> dist(n,INT_MAX);
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
    pq.push({0,s});
    dist[s]=0;

    while(!pq.empty()){
        pair<int,int> p = pq.top(); pq.pop();
        int d = p.first, u = p.second;

        for(auto &v:adj[u]){
            if(d+v.second<dist[v.first]){
                dist[v.first]=d+v.second;
                pq.push({dist[v.first],v.first});
            }
        }
    }

    vector<pair<int,int>> arr;
    for(int i=0;i<n;i++) arr.push_back({dist[i],i});
    sort(arr.begin(),arr.end());

    vector<int> ans;
    for(int i=0;i<min(k,n);i++) ans.push_back(arr[i].second);
    return ans;
}

/* ================= PROBLEM 6 ================= */
bool detectCycle(int n, vector<vector<int>>& edges) {
    vector<vector<int>> adj(n);
    vector<int> indeg(n,0);

    for(auto &e:edges){
        adj[e[0]].push_back(e[1]);
        indeg[e[1]]++;
    }

    queue<int> q;
    for(int i=0;i<n;i++) if(indeg[i]==0) q.push(i);

    int cnt=0;
    while(!q.empty()){
        int u=q.front(); q.pop();
        cnt++;
        for(int v:adj[u]){
            if(--indeg[v]==0) q.push(v);
        }
    }
    return cnt!=n;
}

/* ================= PROBLEM 7 ================= */
double maxAverage(vector<vector<int>>& edges, int src, int dst, int n) {
    vector<vector<pair<int,int>>> adj(n);
    for(auto &e:edges)
        adj[e[0]].push_back({e[1],e[2]});

    queue<pair<int,pair<int,int>>> q;
    q.push({src,{0,0}});

    double ans = -1;

    while(!q.empty()){
        auto cur=q.front(); q.pop();
        int u=cur.first, sum=cur.second.first, cnt=cur.second.second;

        if(u==dst && cnt>0){
            ans = max(ans, (double)sum/cnt);
        }

        for(auto &v:adj[u]){
            q.push({v.first,{sum+v.second,cnt+1}});
        }
    }
    return ans;
}

/* ================= PROBLEM 8 ================= */
int shortestVisitAll(vector<vector<int>>& graph) {
    int n=graph.size();
    queue<pair<int,int>> q;
    vector<vector<bool>> vis(n,vector<bool>(1<<n,false));

    for(int i=0;i<n;i++){
        q.push({i,1<<i});
        vis[i][1<<i]=true;
    }

    int steps=0;
    while(!q.empty()){
        int sz=q.size();
        while(sz--){
            pair<int,int> p=q.front(); q.pop();
            int u=p.first, mask=p.second;

            if(mask==(1<<n)-1) return steps;

            for(int v:graph[u]){
                int nm=mask|(1<<v);
                if(!vis[v][nm]){
                    vis[v][nm]=true;
                    q.push({v,nm});
                }
            }
        }
        steps++;
    }
    return -1;
}

/* ================= PROBLEM 9 ================= */
int minGridPath(vector<vector<int>>& grid) {
    int n=grid.size(), m=grid[0].size();
    priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> pq;
    pq.push({grid[0][0],0,0});
    vector<vector<int>> dist(n,vector<int>(m,INT_MAX));
    dist[0][0]=grid[0][0];

    int dx[4]={1,-1,0,0}, dy[4]={0,0,1,-1};

    while(!pq.empty()){
        auto cur=pq.top(); pq.pop();
        int cost=cur[0], x=cur[1], y=cur[2];

        if(x==n-1 && y==m-1) return cost;

        for(int i=0;i<4;i++){
            int nx=x+dx[i], ny=y+dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<m){
                if(cost+grid[nx][ny]<dist[nx][ny]){
                    dist[nx][ny]=cost+grid[nx][ny];
                    pq.push({dist[nx][ny],nx,ny});
                }
            }
        }
    }
    return -1;
}

/* ================= PROBLEM 10 ================= */
void dfs1(int u, vector<vector<int>>& adj, vector<bool>& vis, stack<int>& st){
    vis[u]=true;
    for(int v:adj[u])
        if(!vis[v]) dfs1(v,adj,vis,st);
    st.push(u);
}
void dfs2(int u, vector<vector<int>>& rev, vector<bool>& vis){
    vis[u]=true;
    for(int v:rev[u])
        if(!vis[v]) dfs2(v,rev,vis);
}
int countSCC(int n, vector<vector<int>>& edges){
    vector<vector<int>> adj(n), rev(n);
    for(auto &e:edges){
        adj[e[0]].push_back(e[1]);
        rev[e[1]].push_back(e[0]);
    }

    stack<int> st;
    vector<bool> vis(n,false);
    for(int i=0;i<n;i++)
        if(!vis[i]) dfs1(i,adj,vis,st);

    fill(vis.begin(),vis.end(),false);
    int cnt=0;
    while(!st.empty()){
        int u=st.top(); st.pop();
        if(!vis[u]){
            dfs2(u,rev,vis);
            cnt++;
        }
    }
    return cnt;
}

/* ================= MAIN ================= */
int main(){
    int choice;
    cout<<"Enter Problem Number (1-10): ";
    cin>>choice;

    switch(choice){
        case 1:{
            vector<vector<int>> flights={{0,1,100},{1,2,100},{2,3,100},{0,3,500}};
            cout<<cheapestFlight(4,flights,0,3,1);
            break;
        }
        case 2:{
            vector<vector<int>> edges={{0,1,3},{1,2,4},{0,2,5}};
            cout<<safestPath(3,edges,0,2);
            break;
        }
        case 3:{
            vector<int> time={3,2,5};
            vector<vector<int>> edges={{0,2},{1,2}};
            cout<<minTimeTasks(time,edges);
            break;
        }
        case 4:{
            vector<vector<int>> mat={{0,1,4},{1,0,2},{4,2,0}};
            auto res=dijkstraMatrix(mat,0);
            for(int x:res) cout<<x<<" ";
            break;
        }
        case 5:{
            vector<vector<int>> edges={{0,1,2},{0,2,4},{1,2,1}};
            auto res=kNearest(3,edges,0,2);
            for(int x:res) cout<<x<<" ";
            break;
        }
        case 6:{
            vector<vector<int>> edges={{0,1},{1,2},{2,0}};
            cout<<(detectCycle(3,edges)?"true":"false");
            break;
        }
        case 7:{
            vector<vector<int>> edges={{0,1,5},{1,2,3}};
            cout<<maxAverage(edges,0,2,3);
            break;
        }
        case 8:{
            vector<vector<int>> g={{1},{0,2},{1,3},{2}};
            cout<<shortestVisitAll(g);
            break;
        }
        case 9:{
            vector<vector<int>> grid={{1,3,1},{1,5,1},{4,2,1}};
            cout<<minGridPath(grid);
            break;
        }
        case 10:{
            vector<vector<int>> edges={{0,1},{1,2},{2,0},{2,3}};
            cout<<countSCC(4,edges);
            break;
        }
        default:
            cout<<"Invalid Choice";
    }
    return 0;
}
