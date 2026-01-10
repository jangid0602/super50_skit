/**
 * @filename - Story8.cpp
 * @description -  String tilling challenge
 * @author - Fatimi Bee
 */

#include <iostream>
#include <string>
#include <vector>

using namespace std;

void compressTile(const string &tileString, int index, int tileSize, string &resultString)
{
    if (index >= tileSize)
        return;
    char currentChar = tileString[index];
    int count = 1;
    while (index + count < tileSize && tileString[index + count] == currentChar)
        count++;

    resultString += to_string(count);
    resultString += currentChar;
    compressTile(tileString, index + count, tileSize, resultString);
}

int main()
{
    string tileString;
    cout << "Enter the string to be tiled: ";
    getline(cin, tileString);

    int tileSize = tileString.size();
    string resultString = "";

    compressTile(tileString, 0, tileSize, resultString);
    cout << "The compressed string is : " << resultString;
    cin.ignore();
    return 0;
}