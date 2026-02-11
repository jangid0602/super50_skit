/**
 * @filename - task1.cpp
 * @description - The floor is lava
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
using namespace std;

int lava(vector<int> &nums, int maximumJump)
{
    int i = 0;
    int j = 0;
    int n = nums.size();
    int length = 0;
    while (j < n - 1)
    {
        if (abs(nums[j] - nums[j + 1]) > maximumJump)
        {
            length = max(length, j - i + 1);
            i = j + 1;
        }
        j++;
    }
    length = max(length, n - i);
    return length;
}

int main()
{
    cout << "Enter the size of an array \n";
    int size;
    cin >> size;
    vector<int> array(size);

    for (int i = 0; i < size; i++)
    {
        cout << "Enter element at " << i + 1 << "th place" << endl;
        cin >> array[i];
    }
    int maximumJump;
    cout << "Enter the maximum jump \n";
    cin >> maximumJump;

    int maximumLength = lava(array, maximumJump);
    cout << "The maximum length of floor lava is " << maximumLength;
}