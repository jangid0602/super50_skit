#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <sstream>
#include <algorithm>
#include <limits>
using namespace std;

// ================================================================
// 1. Trendsetter Score

int trendsetterScore(const vector<int> &posts, int k)
{
    int n = posts.size();
    if (n == 0 || k <= 0 || k > n) return 0;

    int score = 0;

    for (int i = 0; i + k <= n; ++i) 
    {
        unordered_map<int, int> freq;
        for (int j = i; j < i + k; ++j)
            freq[posts[j]]++;

        int maxFreq = 0, countMax = 0;
        for (auto &p : freq)
            if (p.second > maxFreq)
                maxFreq = p.second;

        for (auto &p : freq)
            if (p.second == maxFreq)
                countMax++;

        if (countMax == 1)
            score++;
    }

    return score;
}

// ================================================================
// 2. Encoded String Subsets
bool encodedSubset(const string &superstring, const string &substring)
{
    if (substring.size() > superstring.size())
        return false;
    vector<int> target(26, 0), window(26, 0);
    for (char c : substring)
        target[c - 'a']++;
    int n = (int)superstring.size(), m = (int)substring.size();
    for (int i = 0; i < n; i++)
    {
        window[superstring[i] - 'a']++;
        if (i >= m)
            window[superstring[i - m] - 'a']--;
        if (window == target)
            return true;
    }
    return false;
}

// ================================================================
// 3. E-Commerce Funnel Analysis
string funnelAnalysis(const vector<string> &actions)
{
    unordered_map<string, vector<string>> userPages;
    unordered_map<string, int> pathCount;

    for (auto &act : actions)
    {
        stringstream ss(act);
        string uid, page;
        getline(ss, uid, ',');
        getline(ss, page, ',');
        userPages[uid].push_back(page);
    }

    for (auto &u : userPages)
    {
        for (int i = 0; i + 1 < (int)u.second.size(); ++i)
        {
            string path = u.second[i] + "," + u.second[i + 1];
            pathCount[path]++;
        }
    }

    string ans = "";
    int mx = 0;
    for (auto &p : pathCount)
    {
        if (p.second > mx || (p.second == mx && p.first < ans))
        {
            ans = p.first;
            mx = p.second;
        }
    }
    return ans;
}

// ================================================================
// 4. Maximal Pair Matching
int maxPairMatching(const vector<int> &nums, int k)
{
    unordered_map<int,int> freq;
    for (int x : nums) freq[x]++;
    int pairs = 0;
    for (auto &pr : freq) {
        int x = pr.first;
        int fx = pr.second;
        int y = k - x;
        if (x < y) {
            // pair x with y
            if (freq.count(y)) {
                pairs += min(fx, freq[y]);
            }
        } else if (x == y) {
            
            pairs += fx / 2;
        }
    }
    return pairs;
}

// ================================================================
// 5. Subarray Color Balance
int subarrayColorBalance(const vector<int> &nums)
{
    unordered_map<int,int> firstIndex;
    firstIndex[0] = -1;
    int diff = 0;
    int best = 0;
    for (int i = 0; i < (int)nums.size(); ++i) {
        if (nums[i] == 1) diff++;
        else if (nums[i] == 2) diff--;
        if (firstIndex.find(diff) != firstIndex.end()) {
            best = max(best, i - firstIndex[diff]);
        } else {
            firstIndex[diff] = i;
        }
    }
    return best;
}

// ================================================================
// 6. Text Editor Non-Overlapping Replace
string textReplace(const string &text, const string &find_str, const string &replace_str)
{
    string res;
    for (size_t i = 0; i < text.size();)
    {
        if (text.substr(i, find_str.size()) == find_str)
        {
            res += replace_str;
            i += find_str.size();
        }
        else
        {
            res += text[i++];
        }
    }
    return res;
}

// ================================================================
// 7. Log File Compaction
string logCompaction(const string &logs)
{
    stringstream ss(logs);
    vector<string> arr;
    string word;
    while (ss >> word)
        arr.push_back(word);
    string res;
    for (size_t i = 0; i < arr.size();)
    {
        size_t j = i;
        while (j < arr.size() && arr[j] == arr[i])
            j++;
        res += arr[i] + "(" + to_string(j - i) + ")";
        if (j < arr.size())
            res += " ";
        i = j;
    }
    return res;
}

// ================================================================
// 8. SKU Normalization
string skuNormalization(string sku)
{
    transform(sku.begin(), sku.end(), sku.begin(), ::toupper);
    vector<string> parts;
    string part;
    stringstream ss(sku);
    while (getline(ss, part, '-'))
        parts.push_back(part);

    if (parts.size() != 3)
        return "INVALID";
    string cat = parts[0], id = parts[1], size = parts[2];
    bool valid = true;
    if (cat.size() < 3 || cat.size() > 4)
        valid = false;
    if (id.size() < 4 || id.size() > 6 || !all_of(id.begin(), id.end(), ::isdigit))
        valid = false;
    if (!(size == "S" || size == "M" || size == "L" || size == "XL"))
        valid = false;
    return valid ? sku : "INVALID";
}

// ================================================================
// 9. Chat Message Redaction

string chatRedaction(string message, const vector<string> &bannedWords)
{
    for (const string &b : bannedWords) {
        if (b.empty()) continue;
        size_t pos = 0;
        while (pos < message.size()) {
            pos = message.find(b, pos);
            if (pos == string::npos) break;
            message.replace(pos, b.size(), string(b.size(), '*'));
            pos += b.size();
        }
    }
    return message;
}
// ================================================================
// 10. Resume Keyword Versioning
int resumeVersioning(const vector<string> &v1, const vector<string> &v2)
{
    unordered_map<string, int> f1, f2;
    for (auto &x : v1)
        f1[x]++;
    for (auto &x : v2)
        f2[x]++;
    int score = 0;
    for (auto &p : f1)
    {
        if (f2.count(p.first))
            score += min(p.second, f2[p.first]);
    }
    return score;
}

// ================================================================
// MAIN FUNCTION
int main()
{
    while (true)
    {
        cout << "\n=== WEEK 2 STORIES MENU ===\n";
        cout << "1. The Trendsetter Score\n";
        cout << "2. Encoded String Subsets\n";
        cout << "3. E-Commerce Funnel Analysis\n";
        cout << "4. Maximal Pair Matching\n";
        cout << "5. Subarray Color Balance\n";
        cout << "6. Text Editor Non-Overlapping Replace\n";
        cout << "7. Log File Compaction\n";
        cout << "8. E-commerce SKU Normalization\n";
        cout << "9. Chat Message Redaction\n";
        cout << "10. Resume Keyword Versioning\n";
        cout << "11. Exit\n";
        cout << "Enter your choice: ";

        int choice;
        cin >> choice;

        if (cin.fail())
        {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid input! Please enter a number.\n";
            continue;
        }
        if (choice == 11)
        {
            cout << "Exiting... Goodbye!\n";
            break;
        }

        // ----- perform user choice -----
        if (choice == 1)
        {
            int n, k;
            cout << "Enter number of posts: ";
            cin >> n;
            vector<int> posts(n);
            cout << "Enter posts: ";
            for (int &x : posts)
                cin >> x;
            cout << "Enter window size k: ";
            cin >> k;
            cout << trendsetterScore(posts, k) << "\n";
        }
        else if (choice == 2)
        {
            string superstring, substring;
            cout << "Enter superstring: ";
            cin >> superstring;
            cout << "Enter substring: ";
            cin >> substring;
            cout << (encodedSubset(superstring, substring) ? "true" : "false") << "\n";
        }
        else if (choice == 3)
        {
            int n;
            cout << "Enter number of actions: ";
            cin >> n;
            vector<string> actions(n);
            cout << "Enter actions (userID,pageID):\n";
            for (int i = 0; i < n; i++)
                cin >> actions[i];
            cout << funnelAnalysis(actions) << "\n";
        }
        else if (choice == 4)
        {
            int n, k;
            cout << "Enter number of elements: ";
            cin >> n;
            vector<int> nums(n);
            cout << "Enter array: ";
            for (int &x : nums)
                cin >> x;
            cout << "Enter target sum k: ";
            cin >> k;
            cout << maxPairMatching(nums, k) << "\n";
        }
        else if (choice == 5)
        {
            int n;
            cout << "Enter number of elements: ";
            cin >> n;
            vector<int> nums(n);
            cout << "Enter array: ";
            for (int &x : nums)
                cin >> x;
            cout << subarrayColorBalance(nums) << "\n";
        }
        else if (choice == 6)
        {
            cin.ignore();
            string text, find_str, replace_str;
            cout << "Enter text: ";
            getline(cin, text);
            cout << "Enter find_str: ";
            getline(cin, find_str);
            cout << "Enter replace_str: ";
            getline(cin, replace_str);
            cout << textReplace(text, find_str, replace_str) << "\n";
        }
        else if (choice == 7)
        {
            cin.ignore();
            string logs;
            cout << "Enter logs: ";
            getline(cin, logs);
            cout << logCompaction(logs) << "\n";
        }
        else if (choice == 8)
        {
            string sku;
            cout << "Enter sku: ";
            cin >> sku;
            cout << skuNormalization(sku) << "\n";
        }
        else if (choice == 9)
        {
            cin.ignore();
            string message;
            int n;
            cout << "Enter message: ";
            getline(cin, message);
            cout << "Enter number of banned words: ";
            cin >> n;
            vector<string> bannedWords(n);
            cout << "Enter banned words: ";
            for (int i = 0; i < n; i++)
                cin >> bannedWords[i];
            cout << chatRedaction(message, bannedWords) << "\n";
        }
        else if (choice == 10)
        {
            int n1, n2;
            cout << "Enter number of keywords in resumeV1: ";
            cin >> n1;
            vector<string> resumeV1(n1);
            cout << "Enter resumeV1: ";
            for (auto &x : resumeV1)
                cin >> x;
            cout << "Enter number of keywords in resumeV2: ";
            cin >> n2;
            vector<string> resumeV2(n2);
            cout << "Enter resumeV2: ";
            for (auto &x : resumeV2)
                cin >> x;
            cout << resumeVersioning(resumeV1, resumeV2) << "\n";
        }
        else
            cout << "Invalid choice! Try again.\n";
    }
    return 0;
}
