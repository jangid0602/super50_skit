/*
------------------------------------------------------------
File Name   : Week2Stories.cpp
Author      : Ram Goyal
Description : This program implements multiple problem solutions
              such as Trendsetter Score, Encoded String Subset,
              E-Commerce Funnel, Maximal Pair Matching,
              Subarray Color Balance, Text Replace, Log Compaction,
              SKU Normalization, Chat Redaction, and Resume Versioning.
------------------------------------------------------------
*/

#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
#include <sstream>
#include <algorithm>
using namespace std;

// ------------------------------------------------------------
// 1. The Trendsetter Score
// ------------------------------------------------------------
int trendsetterScore(vector<int>& posts, int k) {
    int score = 0;
    unordered_map<int, int> freq;

    for (int i = 0; i < k; i++) freq[posts[i]]++;

    auto uniqueMax = [&](unordered_map<int,int>& f) {
        int maxFreq = 0, cnt = 0;
        for (auto &p : f) {
            if (p.second > maxFreq) { maxFreq = p.second; cnt = 1; }
            else if (p.second == maxFreq) cnt++;
        }
        return cnt == 1;
    };

    if (uniqueMax(freq)) score++;
    for (int i = k; i < posts.size(); i++) {
        freq[posts[i - k]]--;
        if (freq[posts[i - k]] == 0) freq.erase(posts[i - k]);
        freq[posts[i]]++;
        if (uniqueMax(freq)) score++;
    }

    return score;
}

// ------------------------------------------------------------
// 2. Encoded String Subset
// ------------------------------------------------------------
bool encodedStringSubset(string s1, string s2) {
    if (s2.size() > s1.size()) return false;

    vector<int> a(26, 0), b(26, 0);
    for (char c : s2) b[c - 'a']++;
    for (int i = 0; i < s2.size(); i++) a[s1[i] - 'a']++;

    if (a == b) return true;
    for (int i = s2.size(); i < s1.size(); i++) {
        a[s1[i] - 'a']++;
        a[s1[i - s2.size()] - 'a']--;
        if (a == b) return true;
    }
    return false;
}

// ------------------------------------------------------------
// 3. E-Commerce Funnel Analysis
// ------------------------------------------------------------
string eCommerceFunnel(vector<string>& actions) {
    unordered_map<string, vector<string>> users;

    for (auto &act : actions) {
        int pos = act.find(',');
        string user = act.substr(0, pos);
        string page = act.substr(pos + 1);
        users[user].push_back(page);
    }

    map<string, int> count;
    for (auto &u : users) {
        auto &pages = u.second;
        for (int i = 0; i + 1 < pages.size(); i++)
            count[pages[i] + "," + pages[i + 1]]++;
    }

    int mx = 0;
    string ans = "";
    for (auto &p : count)
        if (p.second > mx) { mx = p.second; ans = p.first; }

    return ans;
}

// ------------------------------------------------------------
// 4. Maximal Pair Matching
// ------------------------------------------------------------
int maximalPairMatching(vector<int>& arr, int k) {
    unordered_map<int, int> freq;
    int pairs = 0;

    for (int x : arr) {
        int y = k - x;
        if (freq[y] > 0) { pairs++; freq[y]--; }
        else freq[x]++;
    }
    return pairs;
}

// ------------------------------------------------------------
// 5. Subarray Color Balance
// ------------------------------------------------------------
int subarrayColorBalance(vector<int>& arr) {
    unordered_map<int, int> first;
    first[0] = -1;
    int diff = 0, ans = 0;

    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == 1) diff++;
        else if (arr[i] == 2) diff--;
        if (first.count(diff)) ans = max(ans, i - first[diff]);
        else first[diff] = i;
    }
    return ans;
}

// ------------------------------------------------------------
// 6. Text Editor Non-Overlapping Replace
// ------------------------------------------------------------
string textReplace(string text, string findStr, string replaceStr) {
    string res = "";
    for (int i = 0; i < text.size();) {
        if (text.substr(i, findStr.size()) == findStr) {
            res += replaceStr;
            i += findStr.size();
        } else res += text[i++];
    }
    return res;
}

// ------------------------------------------------------------
// 7. Log File Compaction
// ------------------------------------------------------------
string logFileCompaction(vector<string>& logs) {
    string ans = "";
    int c = 1;
    for (int i = 1; i <= logs.size(); i++) {
        if (i < logs.size() && logs[i] == logs[i - 1]) c++;
        else {
            ans += logs[i - 1] + "(" + to_string(c) + ") ";
            c = 1;
        }
    }
    return ans;
}

// ------------------------------------------------------------
// 8. E-commerce SKU Normalization
// ------------------------------------------------------------
string skuNormalization(string sku) {
    transform(sku.begin(), sku.end(), sku.begin(), ::toupper);
    vector<string> parts;
    stringstream ss(sku);
    string temp;
    while (getline(ss, temp, '-')) parts.push_back(temp);

    if (parts.size() != 3) return "INVALID";
    string cat = parts[0], id = parts[1], sz = parts[2];

    if (cat.size() < 3 || cat.size() > 4) return "INVALID";
    if (id.size() < 4 || id.size() > 6 || !all_of(id.begin(), id.end(), ::isdigit))
        return "INVALID";
    if (!(sz == "S" || sz == "M" || sz == "L" || sz == "XL"))
        return "INVALID";

    return cat + "-" + id + "-" + sz;
}

// ------------------------------------------------------------
// 9. Chat Message Redaction
// ------------------------------------------------------------
string chatRedaction(string msg, vector<string>& banned) {
    for (auto &w : banned) {
        size_t pos = msg.find(w);
        while (pos != string::npos) {
            msg.replace(pos, w.size(), string(w.size(), '*'));
            pos = msg.find(w, pos + w.size());
        }
    }
    return msg;
}

// ------------------------------------------------------------
// 10. Resume Keyword Versioning
// ------------------------------------------------------------
int resumeKeywordVersioning(vector<string>& v1, vector<string>& v2) {
    unordered_map<string, int> f1, f2;
    for (auto &s : v1) f1[s]++;
    for (auto &s : v2) f2[s]++;

    int score = 0;
    for (auto &p : f1)
        if (f2.count(p.first))
            score += min(p.second, f2[p.first]);

    return score;
}

// ------------------------------------------------------------
// Main Program
// ------------------------------------------------------------
int main() {
    int choice;
    cout << "Enter choice (1-10): ";
    cin >> choice;

    switch (choice) {
        case 1: {
            int n, k;
            cin >> n;
            vector<int> arr(n);
            for (int i = 0; i < n; i++) cin >> arr[i];
            cin >> k;
            cout << trendsetterScore(arr, k) << endl;
            break;
        }

        case 2: {
            string s1, s2;
            cin >> s1 >> s2;
            cout << (encodedStringSubset(s1, s2) ? "true" : "false") << endl;
            break;
        }

        case 3: {
            int n;
            cin >> n;
            vector<string> acts(n);
            for (int i = 0; i < n; i++) cin >> acts[i];
            cout << eCommerceFunnel(acts) << endl;
            break;
        }

        case 4: {
            int n, k;
            cin >> n;
            vector<int> arr(n);
            for (int i = 0; i < n; i++) cin >> arr[i];
            cin >> k;
            cout << maximalPairMatching(arr, k) << endl;
            break;
        }

        case 5: {
            int n;
            cin >> n;
            vector<int> arr(n);
            for (int i = 0; i < n; i++) cin >> arr[i];
            cout << subarrayColorBalance(arr) << endl;
            break;
        }

        case 6: {
            string text, f, r;
            cin >> text >> f >> r;
            cout << textReplace(text, f, r) << endl;
            break;
        }

        case 7: {
            int n;
            cin >> n;
            vector<string> logs(n);
            for (int i = 0; i < n; i++) cin >> logs[i];
            cout << logFileCompaction(logs) << endl;
            break;
        }

        case 8: {
            string sku;
            cin >> sku;
            cout << skuNormalization(sku) << endl;
            break;
        }

        case 9: {
            string msg;
            cin.ignore();
            getline(cin, msg);
            int n;
            cin >> n;
            vector<string> banned(n);
            for (int i = 0; i < n; i++) cin >> banned[i];
            cout << chatRedaction(msg, banned) << endl;
            break;
        }

        case 10: {
            int n1, n2;
            cin >> n1;
            vector<string> v1(n1);
            for (int i = 0; i < n1; i++) cin >> v1[i];
            cin >> n2;
            vector<string> v2(n2);
            for (int i = 0; i < n2; i++) cin >> v2[i];
            cout << resumeKeywordVersioning(v1, v2) << endl;
            break;
        }

        default:
            cout << "Invalid Choice\n";
    }

    return 0;
}
