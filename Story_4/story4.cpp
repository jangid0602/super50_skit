#include <iostream>
#include <vector>
#include <string>
using namespace std;

/*--------------------------------------------------
1. The Russian Doll Mystery (Recursion)
--------------------------------------------------*/
struct Doll {
    int size;
    bool hasKey;
    Doll* inner;

    Doll(int s, bool k = false) {
        size = s;
        hasKey = k;
        inner = NULL;
    }
};

void findKey(Doll* doll) {
    if (doll == NULL) return;

    if (doll->hasKey) {
        cout << "Key Found!" << endl;
        return;
    }
    findKey(doll->inner);
}

/*--------------------------------------------------
2. The Staircase Architect (Recursion)
--------------------------------------------------*/
int countWays(int n) {
    if (n == 0 || n == 1) return 1;
    return countWays(n - 1) + countWays(n - 2);
}

/*--------------------------------------------------
3. The Digital Ancestry Tree (Recursion)
--------------------------------------------------*/
struct Person {
    int wealth;
    vector<Person*> children;

    Person(int w) {
        wealth = w;
    }
};

int calculateLegacy(Person* root) {
    if (root == NULL) return 0;

    int sum = root->wealth;
    for (Person* child : root->children) {
        sum += calculateLegacy(child);
    }
    return sum;
}

/*--------------------------------------------------
4. The Word Mirror (Palindrome Recursion)
--------------------------------------------------*/
bool isPalindrome(string s, int l, int r) {
    if (l >= r) return true;
    if (s[l] != s[r]) return false;
    return isPalindrome(s, l + 1, r - 1);
}

/*--------------------------------------------------
5. The Maze Runner (Backtracking)
--------------------------------------------------*/
bool solveMaze(vector<vector<int>>& maze, int x, int y, int n) {
    if (x == n - 1 && y == n - 1) return true;

    if (x >= n || y >= n || maze[x][y] == 0) return false;

    maze[x][y] = 0; // mark visited

    if (solveMaze(maze, x + 1, y, n)) return true;
    if (solveMaze(maze, x, y + 1, n)) return true;

    return false;
}

/*--------------------------------------------------
6. The Perfect Team Assembly (Subsets)
--------------------------------------------------*/
void generateSubsets(vector<string>& arr, int idx,
                     vector<string>& curr) {
    if (idx == arr.size()) {
        cout << "[";
        for (string s : curr) cout << s << " ";
        cout << "]" << endl;
        return;
    }

    generateSubsets(arr, idx + 1, curr);

    curr.push_back(arr[idx]);
    generateSubsets(arr, idx + 1, curr);
    curr.pop_back();
}

/*--------------------------------------------------
7. The Secure Vault Code (Permutations)
--------------------------------------------------*/
void generatePermutations(vector<int>& nums, int idx) {
    if (idx == nums.size()) {
        for (int x : nums) cout << x;
        cout << endl;
        return;
    }

    for (int i = idx; i < nums.size(); i++) {
        swap(nums[idx], nums[i]);
        generatePermutations(nums, idx + 1);
        swap(nums[idx], nums[i]);
    }
}

/*--------------------------------------------------
8. The String Tiling Challenge (Compression)
--------------------------------------------------*/
string compressString(string s, int idx = 0) {
    if (idx >= s.length()) return "";

    int count = 1;
    while (idx + count < s.length() && s[idx] == s[idx + count])
        count++;

    return to_string(count) + s[idx] +
           compressString(s, idx + count);
}

/*--------------------------------------------------
9. The Budget Calculator (Combination Sum)
--------------------------------------------------*/
void combinationSum(vector<int>& prices, int target,
                    vector<int>& curr, int idx) {
    if (target == 0) {
        cout << "[";
        for (int x : curr) cout << x << " ";
        cout << "]" << endl;
        return;
    }
    if (target < 0 || idx == prices.size()) return;

    curr.push_back(prices[idx]);
    combinationSum(prices, target - prices[idx], curr, idx);
    curr.pop_back();

    combinationSum(prices, target, curr, idx + 1);
}

/*--------------------------------------------------
10. The Project Builder's Blueprint (Hierarchy)
--------------------------------------------------*/
struct Task {
    string name;
    vector<Task*> subTasks;

    Task(string n) {
        name = n;
    }
};

void printTasks(Task* root, int level = 0) {
    if (root == NULL) return;

    for (int i = 0; i < level; i++) cout << "  ";
    cout << root->name << endl;

    for (Task* t : root->subTasks)
        printTasks(t, level + 1);
}

/*--------------------------------------------------
MAIN (Menu Driven)
--------------------------------------------------*/
int main() {
    int choice;
    cout << "Enter Question Number (1-10): ";
    cin >> choice;

    switch (choice) {

    case 1: {
        Doll* d1 = new Doll(5);
        Doll* d2 = new Doll(4);
        Doll* d3 = new Doll(3);
        Doll* d4 = new Doll(2);
        Doll* d5 = new Doll(1, true);

        d1->inner = d2;
        d2->inner = d3;
        d3->inner = d4;
        d4->inner = d5;

        findKey(d1);
        break;
    }

    case 2:
        cout << countWays(3) << endl;
        break;

    case 3: {
        Person* A = new Person(100);
        Person* B = new Person(50);
        Person* C = new Person(50);
        A->children.push_back(B);
        A->children.push_back(C);

        cout << calculateLegacy(A) << endl;
        break;
    }

    case 4: {
        string s = "racecar";
        cout << (isPalindrome(s, 0, s.length() - 1) ? "True" : "False") << endl;
        break;
    }

    case 5: {
        vector<vector<int>> maze = {{1,0},{1,1}};
        cout << (solveMaze(maze, 0, 0, 2) ? "True" : "False") << endl;
        break;
    }

    case 6: {
        vector<string> devs = {"DevA", "DevB"};
        vector<string> curr;
        generateSubsets(devs, 0, curr);
        break;
    }

    case 7: {
        vector<int> nums = {1,2,3};
        generatePermutations(nums, 0);
        break;
    }

    case 8:
        cout << compressString("AAB") << endl;
        break;

    case 9: {
        vector<int> prices = {2,3};
        vector<int> curr;
        combinationSum(prices, 5, curr, 0);
        break;
    }

    case 10: {
        Task* t1 = new Task("Fix Bugs");
        Task* t2 = new Task("UI Bugs");
        Task* t3 = new Task("Button Color");

        t1->subTasks.push_back(t2);
        t2->subTasks.push_back(t3);

        printTasks(t1);
        break;
    }

    default:
        cout << "Invalid Choice" << endl;
    }

    return 0;
}
