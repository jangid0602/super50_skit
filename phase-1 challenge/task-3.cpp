//Encrypted Palindrome  

#include<iostream>
#include<string>
using namespace std;
class Solution {
    public:
    bool isTransformedPalindrome(const string& input){
    string transformed;
    for(char ch : input){
        switch(ch){
            case 'a': transformed += 'e'; break;
            case 'e': transformed += 'i'; break;
            case 'i': transformed += 'o'; break;
            case 'o': transformed += 'u'; break;
            case 'u': transformed += 'a'; break;
            default: transformed += ch; 
        }
    }
    int left = 0;
    int right = transformed.size() - 1;
    while(left < right){
        if(transformed[left] != transformed[right]){
            return false;
        }
        left++;
        right--;
    }
    return true;
}
};

int main(){
    string input;
    cout << "Enter a string: ";
    cin >> input;
    Solution sol;
    if(sol.isTransformedPalindrome(input)){
        cout << "The transformed string is a palindrome." << endl;
    } else {
        cout << "The transformed string is not a palindrome." << endl;
    }
    return 0;
}