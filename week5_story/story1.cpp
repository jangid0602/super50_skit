/**
 * @filename   - story1.cpp
 * @description - Program to count palindromic paths in a binary tree
 * @author     - Ehtesham Nawaz
 */

#include <iostream>
#include <string>
using namespace std;

class Node
{
public:
    char data;
    Node *left;
    Node *right;

    Node(char ch) : data(ch), left(nullptr), right(nullptr) {}
};

void addNode(Node *root, char value, char side)
{
    if (!root)
        return;

    if (side == 'l' || side == 'L')
    {
        if (root->left == nullptr)
            root->left = new Node(value);
        else
            addNode(root->left, value, side);
    }
    else if (side == 'r' || side == 'R')
    {
        if (root->right == nullptr)
            root->right = new Node(value);
        else
            addNode(root->right, value, side);
    }
    else
    {
        cout << "Invalid direction entered.\n";
    }
}

bool canFormPalindrome(const string &path)
{
    int freq[26] = {0};

    for (char ch : path)
        freq[ch - 'a']++;

    int oddFreq = 0;
    for (int i = 0; i < 26; i++)
        if (freq[i] % 2 != 0)
            oddFreq++;

    return oddFreq <= 1;
}

void findPalindromicPaths(Node *root, string currentPath, int &result)
{
    if (!root)
        return;

    currentPath += root->data;

    if (canFormPalindrome(currentPath))
        result++;

    findPalindromicPaths(root->left, currentPath, result);
    findPalindromicPaths(root->right, currentPath, result);
}

void processAllNodes(Node *root, int &result)
{
    if (!root)
        return;

    findPalindromicPaths(root, "", result);
    processAllNodes(root->left, result);
    processAllNodes(root->right, result);
}

int main()
{
    int totalNodes;
    cout << "Enter number of nodes: ";
    cin >> totalNodes;

    if (totalNodes <= 0)
        return 0;

    char rootValue;
    cout << "Enter root node: ";
    cin >> rootValue;

    Node *root = new Node(rootValue);

    for (int i = 1; i < totalNodes; i++)
    {
        char value, direction;
        cout << "Enter node " << i + 1 << ": ";
        cin >> value;

        cout << "Insert '" << value << "' to left or right of root (l/r): ";
        cin >> direction;

        addNode(root, value, direction);
    }

    int palindromicCount = 0;
    processAllNodes(root, palindromicCount);

    cout << "Total palindromic paths: " << palindromicCount << endl;

    return 0;
}
