/**
 * @filename   : story8.cpp
 * @description: E-Commerce SKU Normalization
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

bool allDigits(string s) {
    for (char c : s) if (!isdigit(c)) return false;
    return true;
}
bool allLetters(string s) {
    for (char c : s) if (!isalpha(c)) return false;
    return true;
}

string normalizeSKU(string s) {
    for (char &c : s) c = toupper(c);
    string a = "", b = "", c = "";
    int dash = 0;
    string temp = "";
    for (char ch : s) {
        if (ch == '-') {
            if (dash == 0) a = temp;
            else if (dash == 1) b = temp;
            temp = "";
            dash++;
        } else temp += ch;
    }
    c = temp;

    if (dash != 2) return "INVALID";
    if (a.size() < 3 || a.size() > 4 || !allLetters(a)) return "INVALID";
    if (b.size() < 4 || b.size() > 6 || !allDigits(b)) return "INVALID";
    if (!(c == "S" || c == "M" || c == "L" || c == "XL")) return "INVALID";

    return a + "-" + b + "-" + c;
}

int main() {
    string sku;
    cout << "Enter SKU: ";
    cin >> sku;
    cout << "Normalized SKU: " << normalizeSKU(sku) << endl;
    return 0;
}
