/**
 * @filename - Task-1.cpp
 * @description -  The Palindromic Path Finder 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <string>
using namespace std;

struct TreeNode
{
    char value;
    TreeNode *leftChild;
    TreeNode *rightChild;

    TreeNode(char data)
    {
        value = data;
        leftChild = NULL;
        rightChild = NULL;
    }
};

int palindromePathCount = 0;

bool isPalindromePermutation(const string &pathString)
{
    int frequency[26] = {0};

    for (char ch : pathString)
    {
        if (ch >= 'A' && ch <= 'Z')
            ch = ch - 'A' + 'a';

        if (ch >= 'a' && ch <= 'z')
            frequency[ch - 'a']++;
    }

    int oddFrequencyCount = 0;
    for (int i = 0; i < 26; i++)
    {
        if (frequency[i] % 2 != 0)
            oddFrequencyCount++;
    }

    return oddFrequencyCount <= 1;
}

void countPalindromePaths(TreeNode *currentNode, string currentPath)
{
    if (!currentNode)
        return;

    char nodeValue = currentNode->value;
    if (nodeValue >= 'A' && nodeValue <= 'Z')
        nodeValue = nodeValue - 'A' + 'a';

    currentPath.push_back(nodeValue);

    if (isPalindromePermutation(currentPath))
        palindromePathCount++;

    countPalindromePaths(currentNode->leftChild, currentPath);
    countPalindromePaths(currentNode->rightChild, currentPath);
}

void insertNode(TreeNode *rootNode, char value, char direction)
{
    if (!rootNode)
        return;

    if (direction == 'L' || direction == 'l')
    {
        if (!rootNode->leftChild)
            rootNode->leftChild = new TreeNode(value);
        else
            insertNode(rootNode->leftChild, value, direction);
    }
    else if (direction == 'R' || direction == 'r')
    {
        if (!rootNode->rightChild)
            rootNode->rightChild = new TreeNode(value);
        else
            insertNode(rootNode->rightChild, value, direction);
    }
}

int main()
{
    int totalNodes;
    cout << "Enter number of nodes: ";
    cin >> totalNodes;

    if (totalNodes <= 0)
    {
        cout << "Total palindrome-able paths = 0";
        return 0;
    }

    char rootValue;
    cout << "Enter root value: ";
    cin >> rootValue;

    TreeNode *rootNode = new TreeNode(rootValue);

    for (int i = 0; i < totalNodes - 1; i++)
    {
        char nodeValue, direction;
        cout << "Enter character to add: ";
        cin >> nodeValue;
        cout << "Enter direction (L/R): ";
        cin >> direction;
        insertNode(rootNode, nodeValue, direction);
    }

    palindromePathCount = 0;
    countPalindromePaths(rootNode, "");

    cout << "Total palindrome-able paths = " << palindromePathCount;
    return 0;
}
