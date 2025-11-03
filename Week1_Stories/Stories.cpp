/**
 * @filename - Stories.cpp
 * @description - Stories (1-6)
 * @author - Diya Garg
 */

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// 1. The Efficient Traveler problem

int farthestCity(vector<int> &nums, int initialEnergy)
{
    long long energy = initialEnergy;

    for (int i = 0; i <= nums.size() - 1; i++)
    {
        energy = energy - nums[i];
        if (energy < 0)
            return i;
    }
    return nums.size() - 1;
}

// 2.The Sum That Stands Out

int findIndex(vector<int> &nums)
{
    long long total_sum = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        total_sum += nums[i];
    }
    int suffix_sum;
    int prefix_sum = 0;
    for (int i = 0; i < nums.size(); i++)
    {

        suffix_sum = total_sum - prefix_sum - nums[i];

        if (prefix_sum == suffix_sum)
        {
            return i;
        }
        prefix_sum += nums[i];
    }
    return -1;
}

// 3.Flip the Switch

int minFlips(vector<int> &nums)
{
    int count0 = 0, count1 = 0;
    for (int i = 0; i < nums.size(); i++)
    {
        nums[i] == 0 ? count0++ : count1++;
    }
    return min(count0, count1);
}

// 4. The Odd One Out

int findOddOne(vector<int> &nums)
{
    if (nums.empty())
        return -1;

    //  Find min and max values
    int minVal = nums[0], maxVal = nums[0];
    for (int i = 1; i < nums.size(); i++)
    {
        if (nums[i] < minVal)
            minVal = nums[i];
        if (nums[i] > maxVal)
            ;
        maxVal = nums[i];
    }

    long long range = (long long)maxVal - (long long)minVal + 1;

    //  Range safety check — prevent vector overflow
    if (range > 1e6)
    {

        for (int i = 0; i < nums.size(); i++)
        {
            bool isUnique = true;
            for (int j = 0; j < nums.size(); j++)
            {
                if (i != j && nums[i] == nums[j])
                {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique)
                return nums[i];
        }
        return -1;
    }

    vector<int> freq(range, 0);
    for (int i = 0; i < nums.size(); i++)
    {
        freq[nums[i] - minVal]++;
    }

    for (int i = 0; i < nums.size(); i++)
    {
        if (freq[nums[i] - minVal] == 1)
            return nums[i];
    }

    return -1;
}

// 5. Smart Pair Finder

bool smartPairFinder(int nums[], int k)
{

    bool hash[] = {false};
    int size = sizeof(nums) / sizeof(nums[0]);

    for (int i = 0; i < size; i++)
    {
        int value = k - nums[i];

        if (value >= 0 && hash[value])
            return true;

        if (nums[i] >= 0)
            hash[nums[i]] = true;
    }
    return false;
}

// 6. The Minimalist Painter

int minimalistPainter(int time[], int n)
{
    int total = 0;
    int maxTime = time[0];

    for (int i = 0; i < n; i++)
    {
        total += time[i];
        if (time[i] > maxTime)
            maxTime = time[i];
    }

    return total - maxTime;
}

// main function

int main()
{
    int choice;

    do
    {
        cout << "\n===== Week 1 Problem Menu =====\n";
        cout << "1. The Efficient Traveler\n";
        cout << "2. The Sum That Stands Out\n";
        cout << "3. Flip the Switch\n";
        cout << "4. The Odd One Out\n";
        cout << "5. Smart Pair Finder\n";
        cout << "6. The Minimalist Painter\n";
        cout << "7. Exit\n";
        cout << "Enter your choice (1-7): ";

        // ✅ Input validation
        if (!(cin >> choice))
        {
            cout << "Invalid input! Please enter a number between 1 and 7.\n";
            cin.clear();            // clear fail flag
            cin.ignore(1000, '\n'); // discard invalid input
            continue;               // restart menu
        }

        switch (choice)
        {
        case 1:
        {
            int n, initialEnergy;
            cout << "Enter number of cities: ";
            cin >> n;
            vector<int> nums(n);
            cout << "Enter energy costs: ";
            for (int i = 0; i < n; i++)
                cin >> nums[i];
            cout << "Enter initial energy: ";
            cin >> initialEnergy;

            cout << "Farthest city index: " << farthestCity(nums, initialEnergy) << endl;
            break;
        }

        case 2:
        {
            int n;
            cout << "Enter the number of elements: ";
            cin >> n;
            vector<int> nums(n);
            cout << "Enter elements: ";
            for (int i = 0; i < n; i++)
                cin >> nums[i];

            cout << "Index where prefix == suffix: " << findIndex(nums) << endl;
            break;
        }

        case 3:
        {
            int n;
            cout << "Enter size of elements: ";
            cin >> n;
            vector<int> nums(n);
            cout << "Enter elements (0s/1s): ";
            for (int i = 0; i < n; i++)
                cin >> nums[i];

            cout << "Minimum flips required: " << minFlips(nums) << endl;
            break;
        }

        case 4:
        {
            int n;
            cout << "Enter number of elements: ";
            cin >> n;
            vector<int> nums(n);
            cout << "Enter elements: ";
            for (int i = 0; i < n; i++)
                cin >> nums[i];

            cout << "Odd one out element: " << findOddOne(nums) << endl;
            break;
        }

        case 5:
        {
            int n, k;
            cout << "Enter number of elements: ";
            cin >> n;
            int nums[n];
            cout << "Enter elements: ";
            for (int i = 0; i < n; i++)
                cin >> nums[i];
            cout << "Enter target sum k: ";
            cin >> k;

            if (smartPairFinder(nums, k))
                cout << "Pair found!" << endl;
            else
                cout << "No such pair." << endl;
            break;
        }

        case 6:
        {
            int n;
            cout << "Enter number of walls: ";
            cin >> n;
            int time[n];
            cout << "Enter painting times: ";
            for (int i = 0; i < n; i++)
                cin >> time[i];

            cout << "Minimum total time after skipping one wall: " << minimalistPainter(time, n) << endl;
            break;
        }

        case 7:
            cout << "Exiting program... Goodbye!" << endl;
            break;

        default:
            cout << "Invalid choice! Please enter a number between 1 and 7.\n";
        }

    } while (choice != 7);

    return 0;
}
