//  Oxygen Tank Scrubber  

#include<iostream>
#include<string>
#include<stack>
using namespace std;
class Solution
{
    public:
    void reverse(string& str){
    int left=0;
    int right=str.size()-1;
    while(left<right){
        swap(str[left],str[right]);
        left++;
        right--;
    }
}
    void newString(string& str){
        stack<char> charStack;
    for(char ch : str){
        if(!charStack.empty() && (abs(charStack.top() - ch) == 32)){
            charStack.pop();
        } else {
            charStack.push(ch);
        }
    }
    string result="";
    while(!charStack.empty()){
        result += charStack.top();
        charStack.pop();
    }
    reverse(result);
    cout<<"The final string after all reactions: "<<result<<endl;
    }

};

int main(){
    string input="";
    cout<<"Enter the string representing the oxygen tank scrubber: ";
    cin>>input;
    Solution sol;
    sol.newString(input);
    return 0;
}