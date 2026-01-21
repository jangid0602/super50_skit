#include <iostream>
#include <unordered_map>
#include <vector>
#include <cctype>
using namespace std;

class Solution {
public:
    // ------------------ Problem 1 ------------------
    int countSubarraysWithSum(vector<int>& arr, int target) {
        unordered_map<int, int> prefix_count;
        prefix_count[0] = 1;
        
        int curr_sum = 0, count = 0;
        
        for (int num : arr) {
            curr_sum += num;
            
            if (prefix_count.find(curr_sum - target) != prefix_count.end()) {
                count += prefix_count[curr_sum - target];
            }
            
            prefix_count[curr_sum]++;
        }
        
        return count;
    }

    // ------------------ Problem 2 ------------------
    string shiftingCipher(string s, int k) {
        string result = "";
        for (char c : s) {
            if (isalpha(c)) { // Only shift alphabets
                char base = islower(c) ? 'a' : 'A';
                c = (c - base + k) % 26 + base; // cyclic shift
            }
            result += c;
        }
        return result;
    }
};

int main() {
    Solution sol;
    int choice;
    
    cout << "Choose a problem to solve:\n";
    cout << "1. The Time Traveler’s Array\n";
    cout << "2. The Shifting Cipher\n";
    cout << "Enter your choice: ";
    cin >> choice;
    
    switch (choice) {
        case 1: {
            int n, target;
            cout << "\nEnter array size: ";
            cin >> n;
            vector<int> arr(n);
            cout << "Enter array elements: ";
            for (int i = 0; i < n; ++i) cin >> arr[i];
            cout << "Enter target: ";
            cin >> target;
            
            int result = sol.countSubarraysWithSum(arr, target);
            cout << "\nNumber of subarrays with sum = " << target << " is: " << result << endl;
            break;
        }
        case 2: {
            string s;
            int k;
            cout << "\nEnter the string: ";
            cin.ignore();  // to ignore leftover newline
            getline(cin, s);
            cout << "Enter shift value (k): ";
            cin >> k;
            
            string result = sol.shiftingCipher(s, k);
            cout << "\nShifted string: " << result << endl;
            break;
        }
        default:
            cout << "\nInvalid choice! Please select 1 or 2.\n";
    }

    return 0;
}










