/**
 * @filename - Story4.cpp
 * @description - The Odd One Out 
 * @author - Fatimi Bee 
 */
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int OddOneOut(vector<int>& element) {

    sort(element.begin(), element.end());
    for (int i = 0; i < element.size(); ) {
        int count = 1;
        while (i + 1 < element.size() && element[i] == element[i + 1]) {
            count++;
            i++;
        }
        if (count == 1 ) return element[i];
        i++;
    }
    return -1;

}

// Mainn function
int main()
{
    // Input 

     vector<int> elements;
    cout << "Enter number of elements: ";
    int size;
    cin>>size;

    cout << "Enter elements: ";
    for (int i = 0; i < size; i++)
    {
        int value;
        cin>>value;
        elements.push_back(value);
    }
    // Function call and output
    cout << "The odd one out is: " << OddOneOut(elements) << endl;
}