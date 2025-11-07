/**
 * @filename - story8.cpp
 * @description - E-Commerce SKU Normalization
 * @author - Fatimi Bee 
 */


#include <iostream>
#include <string>
#include <cctype>
using namespace std;

bool isAllDigits(const string& str) {
    for (char ch : str) {
        if (!isdigit(ch)) return false;
    }
    return true;
}

bool isAllLetters(const string& str) {
    for (char ch : str) {
        if (!isalpha(ch)) return false;
    }
    return true;
}

string normalizeSku(string sku) {
    // Convert entire SKU to uppercase
    for (char &ch : sku) {
        ch = toupper(ch);
    }

    // Split using '-' (should have exactly 3 parts)
    string part1 = "", part2 = "", part3 = "";
    int dashCount = 0;
    string temp = "";

    for (char ch : sku) {
        if (ch == '-') {
            if (dashCount == 0) part1 = temp;
            else if (dashCount == 1) part2 = temp;
            temp = "";
            dashCount++;
        } else {
            temp += ch;
        }
    }
    part3 = temp; // last part

    // Validate dash count
    if (dashCount != 2) return "INVALID";

    // Validate category (3-4 letters)
    if (part1.size() < 3 || part1.size() > 4 || !isAllLetters(part1))
        return "INVALID";

    // Validate ID (4-6 digits)
    if (part2.size() < 4 || part2.size() > 6 || !isAllDigits(part2))
        return "INVALID";

    // Validate size (must be S, M, L, or XL)
    if (!(part3 == "S" || part3 == "M" || part3 == "L" || part3 == "XL"))
        return "INVALID";

    // If all valid, return normalized SKU
    return part1 + "-" + part2 + "-" + part3;
}

int main() {
     string sku;
     cout<<"Enter SKU :";
     cin>>sku;
     cout<<"Normalized SKU :"<<normalizeSku(sku)<<endl;
    return 0;
}
