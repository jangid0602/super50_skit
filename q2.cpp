// Missing Page Numbers
// Explanation: You have a book that should have pages from $1$ to $N$. You are given an
// array of pages you actually found. You need to identify the gaps. If a single page is missing,
// return "X". If a range is missing, return "X-Y".
// Test Cases:
// 1. Input: pages = [2, 3, 9], N = 10 ? Output: ["1", "4-8", "10"]
// 2. Input: pages = [1, 2, 3], N = 5 ? Output: ["4-5"]
// 3. Input: pages = [4], N = 4 ? Output: ["1-3"]


#include <iostream>
#include <vector>
#include <algorithm>
#include <string>   

using namespace std;

void findMissingPages(vector<int>& pages, int N) {
    vector<string> missingPages;
    sort(pages.begin(), pages.end());

    int expectedPage = 1;

    for (int i = 0; i < pages.size(); i++) {
        int page = pages[i];

        if (expectedPage < page) {
            int start = expectedPage;
            int end = page - 1;

            if (start == end) {
                missingPages.push_back(to_string(start));
            } else {
                missingPages.push_back(to_string(start) + "-" + to_string(end));
            }
        }
        expectedPage = page + 1;
    }

    if (expectedPage <= N) {
        if (expectedPage == N) {
            missingPages.push_back(to_string(expectedPage));
        } else {
            missingPages.push_back(to_string(expectedPage) + "-" + to_string(N));
        }
    }

   
    for (int i = 0; i < missingPages.size(); i++) {
        cout << missingPages[i] << " ";
    }
    cout << endl;
}

int main() {
    int n, N;

    cout << "Enter number of elements in the array: ";
    cin >> n;

    vector<int> pages(n);
    cout << "Enter the elements of the array: ";
    for (int i = 0; i < n; i++) {
        cin >> pages[i];
    }

    cout << "Enter the total number of pages N: ";
    cin >> N;

    findMissingPages(pages, N);

    return 0;
}

