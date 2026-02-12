/**
 * @filename - story6.cpp
 * @description -  Tree Path maximum k-sum
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
#include <climits>
#include<queue>
using namespace std;

class TreeNode
{
public:
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data) : value(data), left(nullptr), right(nullptr) {}
};

void insert(TreeNode *root, int node)
{
    queue<TreeNode *> q;
    q.push(root);

    while (!q.empty())
    {
        TreeNode *curr = q.front();
        q.pop();

        if (!curr->left)
        {
            curr->left = new TreeNode(node);
            return;
        }
        else
            q.push(curr->left);

        if (!curr->right)
        {
            curr->right = new TreeNode(node);
            return;
        }
        else
            q.push(curr->right);
    }
}
int maximumLength = INT_MIN;

void findLongestPath(TreeNode *root, int targetSum, int currentSum, int length)
{
    if (!root)
        return;

    currentSum += root->value;
    length++;

    if (currentSum == targetSum)
        maximumLength = max(maximumLength, length);

    findLongestPath(root->left, targetSum, currentSum, length);
    findLongestPath(root->right, targetSum, currentSum, length);
}

void find(TreeNode *root, int targetSum)
{
    if (!root)
        return;

    findLongestPath(root, targetSum, 0, 0);
    find(root->left, targetSum);
    find(root->right, targetSum);
}
int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    if (numberOfNodes == 0)
    {
        cout << "Tree cannot be empty\n";
        return 0;
    }

    int value;
    cout << "Enter the root node value: ";
    cin >> value;

    TreeNode *root = new TreeNode(value);

    for (int i = 0; i < numberOfNodes - 1; i++)
    {
        int nodeValue;
        cout << "Enter node value: ";
        cin >> nodeValue;
        insert(root, nodeValue);
    }

    cout << "Tree created successfully\n";

    cout << "Enter the target sum : " << endl;
    int targetSum;
    cin >> targetSum;

    find(root, targetSum);

    cout << "The longest path is : "
         << (maximumLength == INT_MIN ? -1 : maximumLength)
         << endl;
}