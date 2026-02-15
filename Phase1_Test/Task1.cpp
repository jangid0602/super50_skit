// the floor is lava
#include <iostream>
using namespace std;
class Solution
{
public:
    int longestSubarray(int arr[], int n, int k)
    {
        int maxLength = 1;
        int currentLength = 1;
        for (int i =1;i<n; i++)
        {
            if (abs(arr[i]-arr[i - 1])<=k)
            {
                currentLength++;
                maxLength = max(maxLength, currentLength);
            }
            else
            {
                currentLength=1;
            }
        }
        return maxLength;
    }
};

int main()
{
    int size;
    cout << "Enter size of array: ";
    cin >> size;
    int arr[size];
    cout << "Enter array elements: ";
    for (int i=0;i<size;i++)
    {
        cin >> arr[i];
    }
    int k;
    cin >>k;
    Solution obj;
    int result = obj.longestSubarray(arr, size, k);
    cout << "Length of longest subarray: " << result << endl;
    return 0;
}