#include <iostream>
#include <string>
#include <set>
#include <map>
#include <vector>
#include <algorithm>
#include <cctype>
#include <sstream>
using namespace std;

/* -----------------------------------------------
   1. Count Unique Palindromes in a String
   ----------------------------------------------- */
bool isPalindrome(const string &s, int start, int end) {
    while (start < end) {
        if (s[start++] != s[end--])
            return false;
    }
    return true;
}

void countUniquePalindromes() {
    string input;
    cout << "Enter a string: ";
    cin >> input;

    set<string> palSet;
    int n = input.length();

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (isPalindrome(input, i, j))
                palSet.insert(input.substr(i, j - i + 1));
        }
    }

    cout << "Unique palindromic substrings count: " << palSet.size() << endl;
}

/* -----------------------------------------------
   2. Fibonacci Sequence – Nth Number
   ----------------------------------------------- */
int fibonacciNth(int n) {
    if (n <= 1)
        return n;
    int a = 0, b = 1, c;
    for (int i = 2; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

void fibonacciOperation() {
    int n;
    cout << "Enter N: ";
    cin >> n;
    cout << n << "th Fibonacci number is: " << fibonacciNth(n) << endl;
}

/* -----------------------------------------------
   3. Snake Case → Camel Case
   ----------------------------------------------- */
void snakeToCamel() {
    string str;
    cout << "Enter snake_case string: ";
    cin >> str;

    string result;
    bool makeUpper = false;

    for (char ch : str) {
        if (ch == '_') {
            makeUpper = true;
        } else {
            if (makeUpper) {
                result += toupper(ch);
                makeUpper = false;
            } else {
                result += ch;
            }
        }
    }
    cout << "Camel Case: " << result << endl;
}

/* -----------------------------------------------
   4. Count Consonants in a String
   ----------------------------------------------- */
bool isConsonant(char ch) {
    ch = tolower(ch);
    return isalpha(ch) && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
}

void countConsonants() {
    string str;
    cout << "Enter a string: ";
    cin.ignore();
    getline(cin, str);

    int count = 0;
    for (char ch : str) {
        if (isConsonant(ch))
            count++;
    }
    cout << "Number of consonants: " << count << endl;
}

/* -----------------------------------------------
   5. Binary → Decimal
   ----------------------------------------------- */
void binaryToDecimal() {
    string binary;
    cout << "Enter binary number: ";
    cin >> binary;

    int decimal = 0;
    for (char ch : binary) {
        decimal = decimal * 2 + (ch - '0');
    }
    cout << "Decimal equivalent: " << decimal << endl;
}

/* -----------------------------------------------
   6. Characters Expansion (a1b4c3 → abbbbccc)
   ----------------------------------------------- */
void expandCharacters() {
    string input;
    cout << "Enter pattern (e.g., a1b4c3): ";
    cin >> input;

    string result;
    for (int i = 0; i < input.size(); i += 2) {
        char ch = input[i];
        int count = input[i + 1] - '0';
        result.append(count, ch);
    }
    cout << "Expanded string: " << result << endl;
}

/* -----------------------------------------------
   7. Character Frequency Compression (aabccc → a2b1c3)
   ----------------------------------------------- */
void charFrequency() {
    string str;
    cout << "Enter a string: ";
    cin >> str;

    string result;
    int count = 1;

    for (int i = 1; i <= str.size(); i++) {
        if (i < str.size() && str[i] == str[i - 1]) {
            count++;
        } else {
            result += str[i - 1];
            result += to_string(count);
            count = 1;
        }
    }
    cout << "Compressed frequency: " << result << endl;
}

/* -----------------------------------------------
   8. Prime Number Checker
   ----------------------------------------------- */
bool isPrime(int n) {
    if (n <= 1)
        return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0)
            return false;
    }
    return true;
}

void primeChecker() {
    int n;
    cout << "Enter a number: ";
    cin >> n;

    if (isPrime(n))
        cout << "The given number is PRIME" << endl;
    else
        cout << "The given number is NOT prime" << endl;
}

/* -----------------------------------------------
   9. Number to Words Converter (1–999)
   ----------------------------------------------- */
string oneToNineteen[] = {"", "one", "two", "three", "four", "five", "six",
                          "seven", "eight", "nine", "ten", "eleven", "twelve",
                          "thirteen", "fourteen", "fifteen", "sixteen",
                          "seventeen", "eighteen", "nineteen"};
string tensWords[] = {"", "", "twenty", "thirty", "forty", "fifty",
                      "sixty", "seventy", "eighty", "ninety"};

string numberToWords(int num) {
    if (num == 0)
        return "zero";

    string words = "";

    if (num / 100 > 0) {
        words += oneToNineteen[num / 100] + " hundred ";
        num %= 100;
    }

    if (num > 0) {
        if (num < 20)
            words += oneToNineteen[num];
        else {
            words += tensWords[num / 10];
            if (num % 10)
                words += " " + oneToNineteen[num % 10];
        }
    }

    return words;
}

void numberToWordsOperation() {
    int num;
    cout << "Enter number (1–999): ";
    cin >> num;

    cout << "In words: " << numberToWords(num) << endl;
}

/* -----------------------------------------------
   10. Longest Substring Without Repeating Characters
   ----------------------------------------------- */
void longestUniqueSubstring() {
    string s;
    cout << "Enter a string: ";
    cin >> s;

    vector<int> index(256, -1);
    int maxLen = 0, start = 0;

    for (int end = 0; end < s.size(); end++) {
        if (index[s[end]] >= start)
            start = index[s[end]] + 1;
        index[s[end]] = end;
        maxLen = max(maxLen, end - start + 1);
    }

    cout << "Length of longest substring without repeating characters: " << maxLen << endl;
}

/* -----------------------------------------------
   MAIN MENU
   ----------------------------------------------- */
int main() {
    int choice;

    while (true) {
        cout << "\n===== MENU =====\n";
        cout << "1. Count Unique Palindromes\n";
        cout << "2. Fibonacci Sequence – Nth Number\n";
        cout << "3. Snake Case to Camel Case\n";
        cout << "4. Count Consonants\n";
        cout << "5. Binary to Decimal\n";
        cout << "6. Characters Expansion\n";
        cout << "7. Character Frequency Compression\n";
        cout << "8. Prime Number Checker\n";
        cout << "9. Number to Words Converter\n";
        cout << "10. Longest Substring Without Repeating Characters\n";
        cout << "11. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: countUniquePalindromes(); break;
            case 2: fibonacciOperation(); break;
            case 3: snakeToCamel(); break;
            case 4: countConsonants(); break;
            case 5: binaryToDecimal(); break;
            case 6: expandCharacters(); break;
            case 7: charFrequency(); break;
            case 8: primeChecker(); break;
            case 9: numberToWordsOperation(); break;
            case 10: longestUniqueSubstring(); break;
            case 11:
                cout << "Exiting the program. Thank you!\n";
                return 0;
            default:
                cout << "Invalid choice! Try again.\n";
        }
    }
}
