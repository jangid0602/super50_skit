#include <bits/stdc++.h>
using namespace std;

// Function to count max successful elements
int countSuccessfulElements(vector<int>& a, int k) {
    int n = a.size();
    if (n == 0) return 0;

    int curr = 1;
    int ans = 1;

    for (int i = 1; i < n; i++) {
        if (abs(a[i] - a[i - 1]) <= k)
            curr++;
        else
            curr = 1;

        ans = max(ans, curr);
    }
    return ans;
}

int main() {
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++)
        cin >> a[i];

    int k;
    cin >> k;

    cout << countSuccessfulElements(a, k);
    return 0;
}
