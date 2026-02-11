/**
 * @filename - Story7.cpp
 * @description -  The Secret valute code
 * @author - Fatimi Bee
 */

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void generate(vector<int> &numbers, string current, vector<bool> &used, vector<string> &codes, int index)
{
    if (current.length() == 3)
    {
        codes.push_back(current);
        return;
    }
    for (int i = 0; i < numbers.size(); i++)
    {
        if (!used[i])
        {
            used[i] = true;
            generate(numbers, current + to_string(numbers[i]), used, codes, index);
            used[i] = false;
        }
    }
}
int main()
{
    vector<int> numbers(3);
    cout << "Enter 3 number to generate secret codes : " << endl;
    for (int i = 0; i < 3; i++)
    {
        cout << "Enter number " << i + 1 << ":";
        cin >> numbers[i];
    }

    vector<string> codes;
    vector<bool> used(3, false);
    generate(numbers, "", used, codes, 0);
    cout << "All possible secret codes are : " << endl;
    for (const auto &code : codes)
    {
        cout << code << " ";
    }
    cout << endl;
}