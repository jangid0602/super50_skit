#include <iostream>
#include <vector>
using namespace std;

void findMissingPages(vector<int>& pages, int N) {
    int prev = 0;

    for (int i = 0; i < pages.size(); i++) {
        int curr = pages[i];

        if (curr - prev > 1) {
            if (curr - prev == 2)
                cout << prev + 1 << " ";
            else
                cout << prev + 1 << "-" << curr - 1 << " ";
        }
        prev = curr;
    }

    if (N - prev > 0) {
        if (N - prev == 1)
            cout << prev + 1;
        else
            cout << prev + 1 << "-" << N;
    }
}

int main() {
    int n, N;
    cout << "Enter number of found pages: ";
    cin >> n;

    vector<int> pages(n);
    cout << "Enter found pages: ";
    for (int i = 0; i < n; i++) {
        cin >> pages[i];
    }

    cout << "Enter total pages N: ";
    cin >> N;

    cout << "Missing pages: ";
    findMissingPages(pages, N);

    return 0;
}


