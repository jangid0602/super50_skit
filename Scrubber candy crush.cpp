/*5. Oxygen Tank Scrubber*/

#include <iostream>
#include <string>
using namespace std;

string candyCrush(string s){
    string result = "";

    for (char currentChar : s){
        if (!result.empty() &&
            abs(result.back() - currentChar) == 32) {
            result.pop_back();
        } 
		else{
            result.push_back(currentChar);
        }
    }
    return result;
}

int main() {
    string s = "ABbC";
    cout << candyCrush(s);
    return 0;
}

