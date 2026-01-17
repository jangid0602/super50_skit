/**
 * @filename:   Task1.cpp
 * @description: Palindromic Path Finder
 * @author:     Ayushi Shukla
 */

#include <iostream>
#include <string>
using namespace std;

class TreeNode
{
public:
    char value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(char data)
    {
        value = data;
        left = nullptr;
        right = nullptr;
    }
};

void insertNode(TreeNode *rootNode, char nodeValue, char direction)
{
    if (!rootNode)
        return;

    if (direction == 'l' || direction == 'L')
    {
        if (!rootNode->left)
        {
            rootNode->left = new TreeNode(nodeValue);
            return;
        }
        insertNode(rootNode->left, nodeValue, direction);
    }
    else if (direction == 'r' || direction == 'R')
    {
        if (!rootNode->right)
        {
            rootNode->right = new TreeNode(nodeValue);
            return;
        }
        insertNode(rootNode->right, nodeValue, direction);
    }
    else
    {
        cout << "Invalid direction. Use L or R only.\n";
    }
}

// Check whether a string can be rearranged into a palindrome
bool isPalindromePermutation(const string &path)
{
    int frequency[26] = {0};

    for (char c : path)
    {
        if (c >= 'A' && c <= 'Z')
            c = c - 'A' + 'a';

        frequency[c - 'a']++;
    }

    int oddCount = 0;
    for (int i = 0; i < 26; i++)
    {
        if (frequency[i] % 2 != 0)
            oddCount++;
    }

    return oddCount <= 1;
}

// Count palindromic paths starting from a given node
void countPathsFromNode(TreeNode *currentNode, string currentPath, int &totalCount)
{
    if (!currentNode)
        return;

    currentPath.push_back(currentNode->value);

    if (isPalindromePermutation(currentPath))
        totalCount++;

    countPathsFromNode(currentNode->left, currentPath, totalCount);
    countPathsFromNode(currentNode->right, currentPath, totalCount);
}

// Start DFS from every node
void countFromEveryNode(TreeNode *rootNode, int &totalCount)
{
    if (!rootNode)
        return;

    countPathsFromNode(rootNode, "", totalCount);

    countFromEveryNode(rootNode->left, totalCount);
    countFromEveryNode(rootNode->right, totalCount);
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    if (numberOfNodes <= 0)
        return 0;

    char rootValue;
    cout << "Enter root node: ";
    cin >> rootValue;

    TreeNode *rootNode = new TreeNode(rootValue);

    for (int i = 1; i < numberOfNodes; i++)
    {
        char nodeValue, direction;
        cout << "Enter node " << i + 1 << ": ";
        cin >> nodeValue;

        cout << "Insert node '" << nodeValue
             << "' to left or right of root? (L/R): ";
        cin >> direction;

        insertNode(rootNode, nodeValue, direction);
    }

    int palindromePathCount = 0;
    countFromEveryNode(rootNode, palindromePathCount);

    cout << "Total palindromic paths: " << palindromePathCount << endl;
    return 0;
}
