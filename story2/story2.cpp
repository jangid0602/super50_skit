#include <iostream>
#include <vector>
#include <limits>
#include <stdexcept>
#include <string>
#include <unordered_map>
#include <map>
#include <climits>
#include <algorithm>
using namespace std;

/* --------------------------- Helper Function --------------------------- */
int getValidatedInt() {
    int x;
    cin >> x;
    if (cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        throw invalid_argument("Invalid input! Please enter correct input");
    }
    return x;
}

// 1
int trendsetterScore(vector<int> &posts, int k)
{
    int size = posts.size();
    size = posts.size();

    if (size < k)
        return 0;

    int score = 0;

    for (int start = 0; start <= size - k; start++)
    {
        map<int, int> freq;

        for (int index = start; index < start + k; index++)
        {
            int val = posts[index];

            // map insertion and counting manually
            if (freq.find(val) == freq.end())
            {
                freq[val] = 1;
            }
            else
            {
                freq[val] = freq[val] + 1;
            }
        }

        // find maximum frequency
        int maxFreq = 0;
        for (map<int, int>::iterator it = freq.begin(); it != freq.end(); it++)
        {
            int currFreq = it->second;
            if (currFreq > maxFreq)
            {
                maxFreq = currFreq;
            }
        }

        // count how many have max frequency
        int countMax = 0;
        for (auto it = freq.begin(); it != freq.end(); it++)
        {
            if (it->second == maxFreq)
            {
                countMax++;
            }
        }

        // only one most frequent → trendsetter
        if (countMax == 1)
        {
            score++;
        }
    }

    return score;
}

// 2-----------------------------------------------------------------------
bool checkMatch(vector<int> &text, vector<int> &pattern)
{
    for (int index = 0; index < 26; index++)
    {
        if (text[index] != pattern[index])
        {
            return false;
        }
    }
    return true;
}

bool encodedStringSubset(string superString, string subString, int windowSize)
{
    if (superString.length() < subString.length())
    {
        return false;
    }

    // getting freq vector of subString
    vector<int> subStringFreq(26, 0);
    for (int index = 0; index < subString.length(); index++)
    {
        subStringFreq[subString[index] - 'a']++;
    }

    // getting a freq vector of superString of window size
    vector<int> superStringFreq(26, 0);
    int start = 0;
    int end = 0;

    while (end < superString.size())
    {
        superStringFreq[superString[end] - 'a']++;

        if (end - start + 1 == windowSize)
        {
            if (checkMatch(superStringFreq, subStringFreq))
            {
                return true;
            }
            superStringFreq[superString[start] - 'a']--;
            start++;
        }
        end++;
    }

    return false;
}

// 4-----------------------------------------------------------------
int pairMatching(vector<int> &input, int target)
{
    if (input.size() < 2)
        return 0;

    unordered_map<int, int> freq;
    int result = 0;

    for (int num : input)
    {
        int complement = target - num;

        if (freq[complement] > 0)
        {
            result++;
            freq[complement]--;
        }
        else
        {
            freq[num]++;
        }
    }

    return result;
}

// 5===============================================================
int longestBalancedSubarray(vector<int> &nums)
{
    unordered_map<int, int> firstIndex;
    firstIndex[0] = -1; // prefix 0 before start
    int prefix = 0, maxLen = 0;

    for (int index = 0; index < nums.size(); index++)
    {
        if (nums[index] == 1)
            prefix += 1;
        else if (nums[index] == 2)
            prefix -= 1;

        if (firstIndex.find(prefix) != firstIndex.end())
        {
            maxLen = max(maxLen, index - firstIndex[prefix]);
        }
        else
        {
            firstIndex[prefix] = index;
        }
    }

    return maxLen;
}

//6------------------------------------------------------------------------------------
string textEditor(string text, string find_str, string replace_str)
{
    int i = 0;
    int j = 0;
    string tempString = "";
    string finalString = "";

    while (j < text.length())
    {
        tempString += text[j];

        if (j - i + 1 == find_str.length())
        {
            if (find_str == tempString)
            {
                finalString += replace_str;
                tempString = "";
                i = j + 1;
            }
            else
            {
                for (int index = 0; index < tempString.length(); index++)
                {
                    if (index == 0)
                    {
                        finalString += tempString[index];
                    }
                    else
                    {
                        tempString[index - 1] = tempString[index];
                    }
                }

                tempString.pop_back();
                i++;
            }
        }

        j++;
    }

    finalString += tempString;
    return finalString;
}

// 7
string getCompactation(string logs)
{
    vector<string> words;
    string tempString = "";

    // Manually split by space
    for (int index = 0; index <= logs.length(); index++)
    {
        if (index == logs.length() || logs[index] == ' ')
        {
            if (!tempString.empty())
            {
                words.push_back(tempString);
                tempString = "";
            }
        }
        else
        {
            tempString += logs[index];
        }
    }

    if (words.empty())
        return "";

    // Run-length encoding of log levels
    string result = "";
    int count = 1;

    for (int index = 1; index <= words.size(); index++)
    {
        if (index < words.size() && words[index] == words[index - 1])
        {
            count++;
        }
        else
        {
            result += words[index - 1] + "(" + to_string(count) + ")";
            if (index < words.size())
                result += " ";
            count = 1;
        }
    }

    return result;
}

//8==================================================================
bool checkStringInput(const string &input)
{
    for (char c : input)
    {
        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
            return false;
    }

    return !input.empty();
}

bool checkNumericalInput(const string &input)
{
    for (char c : input)
    {
        if (c < '0' || c > '9')
            return false;
    }
    return !input.empty();
}

string toUpperCase(const string &input)
{
    string result = input;
    for (char &c : result)
    {
        if (c >= 'a' && c <= 'z')
            c = c - 'a' + 'A';
    }
    return result;
}

bool checkSize(const string &size)
{
    string upper = toUpperCase(size);
    return (upper == "S" || upper == "M" || upper == "L" || upper == "XL");
}

string normalization(const string &input)
{
    string result = "";
    string invalidString = "INVALID";

    if (input.length() > 14)
        return invalidString;

    string temp = "";
    int step = 1; // 1: string part, 2: number part, 3: size part

    for (int index = 0; index <= input.size(); index++)
    {
        if (index == input.size() || input[index] == '-')
        {
            if (step == 1)
            {
                if (temp.length() < 3 || temp.length() > 4 || !checkStringInput(temp))
                    return invalidString;

                result += toUpperCase(temp) + "-";
                step = 2;
            }
            else if (step == 2)
            {
                if (temp.length() < 4 || temp.length() > 6 || !checkNumericalInput(temp))
                    return invalidString;

                result += temp + "-";
                step = 3;
            }
            else if (step == 3)
            {
                if (temp.length() < 1 || temp.length() > 2 || !checkSize(temp))
                    return invalidString;

                result += toUpperCase(temp);
                step = 0;
            }

            temp = "";
        }
        else
        {
            temp += input[index];
        }
    }

    if (step != 0) // if not all three parts found
        return invalidString;

    return result;
}

//9
string redactMessage(string message, vector<string> &bannedWords)
{
    string result;
    int n = message.size();

    for (int index = 0; index < n;)
    {
        bool matched = false;

        // Check each banned word
        for (string &word : bannedWords)
        {
            int len = word.size();

            if (index + len <= n)
            {
                bool same = true;

                // compare each character
                for (int j = 0; j < len; j++)
                {
                    if (message[index + j] != word[j])
                    {
                        same = false;
                        break;
                    }
                }

                if (same)
                {
                    // Word matched 
                    result.append(len, '*');
                    index += len; // Skip over the banned word
                    matched = true;
                    break;
                }
            }
        }

        if (!matched)
        {
            // No match 
            result.push_back(message[index]);
            index++;
        }
    }

    return result;
}

//10=============================================================================
string toLowerCase(const string &originalString)
{
    string tempString = originalString;
    for (int index = 0; index < tempString.length(); index++)
    {
        if (tempString[index] >= 'A' && tempString[index] <= 'Z')
        {
            tempString[index] = tempString[index] - 'A' + 'a';
        }
    }
    return tempString;
}

int resumeScoring(vector<string> &resume1, vector<string> &resume2)
{
    unordered_map<string, int> freq1, freq2;

    for (int index = 0; index < resume1.size(); index++)
    {
        freq1[toLowerCase(resume1[index])]++;
    }

    for (int index = 0; index < resume2.size(); index++)
    {
        freq2[toLowerCase(resume2[index])]++;
    }

    int score = 0;
    for (auto r1 : freq1)
    {
        string keyword1 = r1.first;
        if (freq2.count(keyword1))
        {
            int firstCount = r1.second;
            int secondCount = freq2[keyword1];
            score += min(firstCount, secondCount);
        }
    }

    return score;
}

/* ============================== MENU DRIVER ============================== */
int main()
{
    while (true)
    {
        try
        {
            
            cout << "0. Exit Program\n";
            cout << "1. The Trendsetter Score\n";
            cout << "2. Encoded String Subset\n";
            cout << "3.  Maximal Pair Matching \n";
            cout << "4. Subarray Color Balance\n";
            cout << "5. Text Editor Non-Overlapping Replace\n";
            cout << "6. Log File Compaction\n";
            cout << "7. Chat Message Redaction\n";
            cout << "8. E-commerce SKU Normalization\n";
            cout << "9. Resume Keyword Versioning\n";
            
            
            cout << "Enter your choice: ";

            int choice = getValidatedInt();

            if (choice == 0)
            {
                char confirm;
                cout << "Are you sure you want to exit? (y/n): ";
                cin >> confirm;
                if (confirm == 'y' || confirm == 'Y') {
                    cout << "Exiting Program!!" << endl;
                    break;
                }
            }

            switch (choice)
            {
            case 1:
            {
                int size, windowSize;
                cout << "Enter size of posts: ";
                cin >> size;

                vector<int> posts(size);
                cout << "Enter post IDs: ";
                for (int i = 0; i < size; i++)
                {
                    cin >> posts[i];
                }

                cout << "Enter window size: ";
                cin >> windowSize;

                int ans = trendsetterScore(posts, windowSize);
                cout << "Trendsetter Score: " << ans << endl;
                break;
            }

            case 2:
            {
                string superString, subString;
                cout << "Enter superString: ";
                cin >> superString;
                cout << "Enter subString: ";
                cin >> subString;

                bool result = encodedStringSubset(superString, subString, subString.length());
                cout << (result ? "True" : "False") << endl;
                break;
            }

            case 3:
            {
                int size;
                cout << "Enter size of array: ";
                cin >> size;

                vector<int> input(size);
                cout << "Enter elements: ";
                for (int i = 0; i < size; i++)
                {
                    cin >> input[i];
                }

                int target;
                cout << "Enter target sum: ";
                cin >> target;

                cout << "Total pairs are " << pairMatching(input, target) << endl;
                break;
            }

            case 4:
            {
                int size;
                cout << "Enter size of array: ";
                cin >> size;

                vector<int> input(size);
                cout << "Enter elements: ";
                for (int i = 0; i < size; i++)
                {
                    cin >> input[i];
                }

                cout << "Result is " << longestBalancedSubarray(input) << endl;
                break;
            }

            case 5:
            {
                string text, find_str, replace_str;
                cout << "Enter text: ";
                cin >> text;
                cout << "Enter find string: ";
                cin >> find_str;
                cout << "Enter replace string: ";
                cin >> replace_str;

                cout << "Updated string is: " << textEditor(text, find_str, replace_str) << endl;
                break;
            }

            case 6:
            {
                cin.ignore();
                string logs;
                cout << "Enter line: ";
                getline(cin, logs);

                cout << "Compactation is: " << getCompactation(logs) << endl;
                break;
            }

            case 7:
            {
                cin.ignore();
                string message;
                cout << "Enter message: ";
                getline(cin, message);

                int size;
                cout << "Enter size of banned words: ";
                cin >> size;

                vector<string> banned(size);
                for (int i = 0; i < size; i++)
                {
                    cout << "Enter banned word: ";
                    cin >> banned[i];
                }

                cout << "Redacted message: " << redactMessage(message, banned) << endl;
                break;
            }

            case 8:
            {
                string sku;
                cout << "Enter SKU: ";
                cin >> sku;

                cout << "Final SKU is: " << normalization(sku) << endl;
                break;
            }

            case 9:
            {
                int size;
                cout << "Enter size of first resume: ";
                cin >> size;

                vector<string> resume1(size);
                for (int i = 0; i < size; i++)
                {
                    cout << "Enter keyword: ";
                    cin >> resume1[i];
                }

                cout << "Enter size of second resume: ";
                cin >> size;

                vector<string> resume2(size);
                for (int i = 0; i < size; i++)
                {
                    cout << "Enter keyword: ";
                    cin >> resume2[i];
                }

                cout << "Total score is: " << resumeScoring(resume1, resume2) << endl;
                break;
            }

            default:
                cout << "Invalid choice! Try again.\n";
                break;
            }
        }
        catch (const invalid_argument &e)
        {
            cout << e.what() << endl;
            cout << "Please try again.\n";
        }
    }

    return 0;
}
