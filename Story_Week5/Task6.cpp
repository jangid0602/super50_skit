/**
 * @filename:    Task6.cpp
 * @description: Tree Path Maximum K-Sum
 * @author:      Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <climits>
#include <queue>
using namespace std;

class TreeNode
{
public:
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data)
    {
        value = data;
        left = nullptr;
        right = nullptr;
    }
};

// Insert node in level order (same logic)
void insertNode(TreeNode *rootNode, int nodeValue)
{
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    while (!nodeQueue.empty())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (!currentNode->left)
        {
            currentNode->left = new TreeNode(nodeValue);
            return;
        }
        else
            nodeQueue.push(currentNode->left);

        if (!currentNode->right)
        {
            currentNode->right = new TreeNode(nodeValue);
            return;
        }
        else
            nodeQueue.push(currentNode->right);
    }
}

// Find longest path with given sum starting from a node
void findLongestPath(
    TreeNode *currentNode,
    int targetSum,
    int currentSum,
    int currentLength,
    int &maximumLength)
{
    if (!currentNode)
        return;

    currentSum += currentNode->value;
    currentLength++;

    if (currentSum == targetSum)
        maximumLength = max(maximumLength, currentLength);

    findLongestPath(currentNode->left, targetSum, currentSum, currentLength, maximumLength);
    findLongestPath(currentNode->right, targetSum, currentSum, currentLength, maximumLength);
}

// Start checking from every node
void findFromEveryNode(TreeNode *rootNode, int targetSum, int &maximumLength)
{
    if (!rootNode)
        return;

    findLongestPath(rootNode, targetSum, 0, 0, maximumLength);

    findFromEveryNode(rootNode->left, targetSum, maximumLength);
    findFromEveryNode(rootNode->right, targetSum, maximumLength);
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

    int rootValue;
    cout << "Enter the root node value: ";
    cin >> rootValue;

    TreeNode *rootNode = new TreeNode(rootValue);

    for (int i = 0; i < numberOfNodes - 1; i++)
    {
        int nodeValue;
        cout << "Enter node value: ";
        cin >> nodeValue;
        insertNode(rootNode, nodeValue);
    }

    cout << "Tree created successfully\n";

    int targetSum;
    cout << "Enter the target sum: ";
    cin >> targetSum;

    int maximumLength = INT_MIN;
    findFromEveryNode(rootNode, targetSum, maximumLength);

    cout << "The longest path is: "
         << (maximumLength == INT_MIN ? -1 : maximumLength)
         << endl;

    return 0;
}
