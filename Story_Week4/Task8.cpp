/**
 * @filename - Task8.cpp
 * @description - The String Tilling Challenge
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <string>
using namespace std;
int main()
{

    string str; // enter input as AABB
    cout << "Enter the string: ";
    cin >> str;
    int n = str.length();
    string result = ""; // to store the tilled string
    for (int i = 0; i < n;)
    {
        // base case
        if (i >= n)
        {
            break;
        }
        // count occurrences of current character
        int count = 1;
        while (i + 1 < n && str[i] == str[i + 1])
        {
            count++;
            i++;
        }
        result += to_string(count);
        result += str[i];
        i++;
    }

    cout << "The Tilled String is: " << result << endl;
    return 0;
}