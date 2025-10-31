#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// ------------------------ Story 1 ------------------------
int EfficientEnergyCalculation(vector<int>& energy, int initialEnergy) {
    int n = energy.size();
    int counted_city = 0;
    for (int i = 0; i < n; i++) {
        if (initialEnergy > 0 && initialEnergy >= energy[i]) {
            counted_city++;
            initialEnergy -= energy[i];
        } else {
            break;
        }
    }
    return counted_city;
}

// ------------------------ Story 2 ------------------------
int suffix_prefix(vector<int>& arr) {
    int n = arr.size();
    vector<int> prefix_sum(n, 0);
    vector<int> suffix_sum(n, 0);

    for (int i = 1; i < n; i++) prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1];
    for (int i = n - 2; i >= 0; i--) suffix_sum[i] = suffix_sum[i + 1] + arr[i + 1];

    for (int i = 0; i < n; i++)
        if (prefix_sum[i] == suffix_sum[i]) return i;

    return -1;
}

// ------------------------ Story 3 ------------------------
int flips(vector<int>& switches) {
    int zeros = 0, ones = 0;
    for (int val : switches) {
        if (val == 0)
            zeros++;
        else
            ones++;
    }
    return min(zeros, ones);
}

// ------------------------ Story 4 ------------------------
int OddOneOut(vector<int>& element) {
    unordered_map<int, int> frequency;
    for (int val : element) frequency[val]++;
    for (auto& it : frequency)
        if (it.second % 2 != 0) return it.first;
    return -1;
}

// ------------------------ Story 5 ------------------------
bool smartPairFinder(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());
    int left = 0, right = nums.size() - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) return true;
        else if (sum < target) left++;
        else right--;
    }
    return false;
}

// ------------------------ Story 6 ------------------------
int MinimalistPainter(vector<int>& time) {
    int n = time.size();
    if (n <= 1) return 0;
    int total_time = 0, max_time = 0;
    for (int val : time) {
        total_time += val;
        max_time = max(max_time, val);
    }
    return total_time - max_time;
}

// ------------------------ Utility Input Validation ------------------------
int getValidatedInt() {
    int x;
    cin >> x;
    if (cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        throw invalid_argument("Invalid input! Please enter a number only.");
    }
    return x;
}

// ------------------------ MAIN FUNCTION ------------------------
int main() {
    while (true) {
        try {
            cout << "\nEnter choice from 1 to 6 to test different stories (0 to exit):\n";
            cout << "1. Efficient Energy Calculation\n"
                 << "2. Suffix Prefix Index Finder\n"
                 << "3. Flip the Switch\n"
                 << "4. The Odd One Out\n"
                 << "5. Smart Pair Finder\n"
                 << "6. Minimalist Painter\n"
                 << "0. Exit\n";
            cout<<"Enter your choice: ";
            int choice = getValidatedInt();

            if (choice == 0) {
                cout << "Exiting program..." << endl;
                break;
            }

            switch (choice) {
                case 1: {
                    vector<int> energy;
                    cout << "Enter number of cities: ";
                    int n = getValidatedInt();
                    cout << "Enter energy values: ";
                    for (int i = 0; i < n; i++) energy.push_back(getValidatedInt());
                    cout << "Enter initial energy: ";
                    int initialEnergy = getValidatedInt();
                    cout << "Maximum cities that can be visited: "
                         << EfficientEnergyCalculation(energy, initialEnergy) << endl;
                    break;
                }

                case 2: {
                    vector<int> arr;
                    cout << "Enter number of elements: ";
                    int n = getValidatedInt();
                    cout << "Enter elements: ";
                    for (int i = 0; i < n; i++) arr.push_back(getValidatedInt());
                    int index = suffix_prefix(arr);
                    if (index != -1)
                        cout << "Index where prefix = suffix: " << index << endl;
                    else
                        cout << "No such index found.\n";
                    break;
                }

                case 3: {
                    vector<int> switches;
                    cout << "Enter number of binary values: ";
                    int n = getValidatedInt();
                    cout << "Enter 0s and 1s: ";
                    for (int i = 0; i < n; i++) switches.push_back(getValidatedInt());
                    cout << "Minimum flips required: " << flips(switches) << endl;
                    break;
                }

                case 4: {
                    vector<int> elements;
                    cout << "Enter number of elements: ";
                    int n = getValidatedInt();
                    cout << "Enter elements: ";
                    for (int i = 0; i < n; i++) elements.push_back(getValidatedInt());
                    cout << "The odd one out is: " << OddOneOut(elements) << endl;
                    break;
                }

                case 5: {
                    vector<int> nums;
                    cout << "Enter number of elements: ";
                    int n = getValidatedInt();
                    cout << "Enter elements: ";
                    for (int i = 0; i < n; i++) nums.push_back(getValidatedInt());
                    cout << "Enter target sum: ";
                    int target = getValidatedInt();
                    if (smartPairFinder(nums, target))
                        cout << "Pair found with the given target sum.\n";
                    else
                        cout << "No pair found.\n";
                    break;
                }

                case 6: {
                    vector<int> time;
                    cout << "Enter number of walls: ";
                    int n = getValidatedInt();
                    cout << "Enter painting times: ";
                    for (int i = 0; i < n; i++) time.push_back(getValidatedInt());
                    cout << "Minimum time to paint all (skipping one): "
                         << MinimalistPainter(time) << endl;
                    break;
                }

                default:
                    cout << "⚠ Invalid choice! Try again.\n";
                    break;
            }
        } catch (const invalid_argument& e) {
            cout << e.what() << endl;
            cout << "Please try again.\n";
        }
    }

    return 0;
}
