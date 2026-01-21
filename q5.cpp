// Oxygen Tank Scrubber
// Explanation: Think of this like "Candy Crush" for characters. If an uppercase letter is next to
// its lowercase version (or vice versa), they "react" and disappear.
// Test Cases:
// 1. Input: s = "aAbBcC" ? Output: "" (All pairs react)
// 2. Input: s = "ABbC" ? Output: "AC" ('B' and 'b' react)
// 3. Input: s = "sSttaA" ? Output: "tt" ('sS' and 'aA' react, 'tt' are both lowercase and stay)

#include <iostream>
#include <string>

using namespace std;
string oxygenTankScrubber(const string& s) {
    string stack;
    for (char c : s) {
        if (!stack.empty() && abs(stack.back() - c) == 32) {
            stack.pop_back();
        } else {
            stack.push_back(c);
        }
    }
    return stack;
}
int main() {
    string s;
    cout << "Enter the string: ";
    getline(cin, s);
    string result = oxygenTankScrubber(s);
    cout << "Resulting string after reactions: " << result << endl;
    return 0;
}

