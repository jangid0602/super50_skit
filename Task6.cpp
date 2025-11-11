// @Filename - Task1.cpp
// @Description -  The Minimalist Painter
// @Author - Ayushi Shukla
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Solution
{
    public:
    int TheMinimalistPainter(vector<int>& time, int size){
        int totalTime=0;
        int maximumElement=-1;
        for(int i=0;i<size;i++){
            totalTime+=time[i];
            if(time[i]>maximumElement){
                maximumElement=time[i];
            }
        }
        return totalTime-maximumElement;
    }
};
int main()
{
    int size;
    cout << "Enter size of array (in integers) : ";
    cin >> size;
    vector<int> time(size);
    cout << "enter array elements (in integer) : " << endl;
    for (int i = 0; i < size; i++)
    {
        cin >> time[i];
    }
    Solution obj;
    cout<<"Minimum total painting time after skipping one wall : "<<obj.TheMinimalistPainter(time,size)<<endl;
}