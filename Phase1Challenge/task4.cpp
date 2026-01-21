/**
 * @filename - task4.cpp
 * @description - mirror word via recursion
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
char mapMirror(char c)
{
    switch (tolower(c))
    {
    case 'b':
        return 'd';
    case 'c':
        return 'c';
    case 'd':
        return 'b';
    case 'e':
        return 'e';
    case 'h':
        return 'h';
    case 'i':
        return 'i';
    case 'k':
        return 'k';
    case 'm':
        return 'm';
    case 'o':
        return 'o';
    case 'p':
        return 'q';
    case 's':
        return 's';
    case 'x':
        return 'x';
    case 'z':
        return 'z';
    case 'q':
        return 'p';
    default:
        return c;
    }
}
bool mirror(int index, int n, string input, string &current)
{
    if (index >= n)
    {
        reverse(input.begin(), input.end());
        return input == current;
    }
    current += mapMirror(input[index]);
    return mirror(index + 1, n, input, current);
}
int main()
{
    cout << "Enter input string: ";
    string input;
    cin >> input;
    string current = "";
    if (mirror(0, input.length(), input, current))
    {
        cout << "Yes, it is a mirror word" << endl;
    }
    else
    {
        cout << "No, it is not a mirror word" << endl;
    }
    return 0;
}