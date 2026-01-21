#include <bits/stdc++.h>
using namespace std;
int countSubarraysWithSum(vector<int>& arr, int target) {
    unordered_map<int, int>mp;
    mp[0] = 1;
    int sum = 0, count = 0;

    for (int num : arr) {
        sum += num;
        if (mp.find(sum - target) != mp.end()) {
            count += mp[sum - target];
        }
        mp[sum]++;
    }
    return count;
}


string shiftingCipher(string s, int k) {
    string result = "";
    
    for (char c : s) {
        if (isupper(c)) {
            int UpperIdx=(c - 'A' + k) % 26;
            result += char('A' + UpperIdx);
        } else if (islower(c)) {
            int LowerIdx=(c - 'a' + k) % 26;
            result += char('a' + LowerIdx);
        } else {
            result += c;
        }
    }
    return result;
}


int main() {
    int choice;
    cout << "====== Gauntlet Challenge SET B ======\n";
    cout << "1. The Time Traveler’s Array\n";
    cout << "2. The Shifting Cipher\n";
    cout << "Choose a problem (1 or 2): ";
    cin >> choice;
    cin.ignore(); // clear newline
    switch (choice) {
        case 1:
        {int n, target;
        cout << "\nEnter array size: ";
        cin >> n;
        vector<int> arr(n);
        cout << "Enter array elements: ";
        for (int i = 0; i < n; i++) cin >> arr[i];
        cout << "Enter target sum: ";
        cin >> target;

        cout << "Output: " << countSubarraysWithSum(arr, target) << endl;
        break;
        }
        case 2:
        {string s;
        int k;
        cout << "\nEnter string: ";
        getline(cin, s);
        cout << "Enter shift value k: ";
        cin >> k;
        cout << "Shifted String is: " << shiftingCipher(s, k) << endl;
    } 
    default:
        cout << "Invalid choice. Please select 1 or 2." << endl;
    }

    return 0;
}
