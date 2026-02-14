/**
 * @filename - Task1.cpp
 * @description - Palindromic path finder
 * @author - Diya Garg
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

    TreeNode(char data) : value(data), left(nullptr), right(nullptr) {}
};

void insert(TreeNode *root, char node, char direction)
{
    if (!root)
        return;

    if (direction == 'l' || direction == 'L')
    {
        if (!root->left)
        {
            root->left = new TreeNode(node);
            return;
        }
        else
        {
            insert(root->left, node, direction);
        }
    }
    else if (direction == 'r' || direction == 'R')
    {
        if (!root->right)
        {
            root->right = new TreeNode(node);
            return;
        }
        else
        {
            insert(root->right, node, direction);
        }
    }
    else
    {
        cout << "Invalid input. Try again.\n";
        insert(root, node, direction);
    }
}

// Check if path can form palindrome
bool isPalindrom(string path)
{
    int frequency[26] = {0};
    for (char c : path)
        frequency[c - 'a']++;

    int oddCount = 0;
    for (int i = 0; i < 26; i++)
        if (frequency[i] % 2 != 0)
            oddCount++;

    return oddCount <= 1;
}

// Count palindromic paths from a given node
void countPalindromicPaths(TreeNode *root, string path, int &count)
{
    if (!root)
        return;

    path += root->value;

    if (isPalindrom(path))
        count++;

    countPalindromicPaths(root->left, path, count);
    countPalindromicPaths(root->right, path, count);
}

void countFromEveryNode(TreeNode *root, int &count)
{
    if (!root)
        return;

    string path = "";
    countPalindromicPaths(root, path, count);

    countFromEveryNode(root->left, count);
    countFromEveryNode(root->right, count);
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    if (numberOfNodes <= 0)
        return 0;

    char node;
    cout << "Enter root node: ";
    cin >> node;

    TreeNode *root = new TreeNode(node);

    for (int i = 1; i < numberOfNodes; i++)
    {
        cout << "Enter node " << i + 1 << ": ";
        cin >> node;
        char direction;

        cout << "Insert node '" << node << "' to left or right of '" << root->value << "'? (l/r): ";
        cin >> direction;

        insert(root, node, direction);
    }

    int counting = 0;
    countFromEveryNode(root, counting);

    cout << "Total palindromic paths: " << counting << endl;
}
