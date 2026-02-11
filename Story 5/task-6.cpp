/**
 * @filename - Task-6.cpp
 * @description - Tree Path Maximum "K-Sum" 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode
{
    int value;
    TreeNode *leftChild;
    TreeNode *rightChild;

    TreeNode(int data)
    {
        value = data;
        leftChild = NULL;
        rightChild = NULL;
    }
};

TreeNode *buildTreeFromLevelOrder(const vector<int> &levelOrder)
{
    if (levelOrder.empty() || levelOrder[0] == -1)
        return NULL;

    TreeNode *rootNode = new TreeNode(levelOrder[0]);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    int index = 1;
    while (!nodeQueue.empty() && index < levelOrder.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (levelOrder[index] != -1)
        {
            currentNode->leftChild = new TreeNode(levelOrder[index]);
            nodeQueue.push(currentNode->leftChild);
        }
        index++;

        if (index < levelOrder.size() && levelOrder[index] != -1)
        {
            currentNode->rightChild = new TreeNode(levelOrder[index]);
            nodeQueue.push(currentNode->rightChild);
        }
        index++;
    }
    return rootNode;
}

void findLongestPath(TreeNode *currentNode, int targetSum,
                     vector<int> &currentPath, int &longestLength)
{
    if (!currentNode)
        return;

    currentPath.push_back(currentNode->value);

    int currentSum = 0;
    for (int i = currentPath.size() - 1; i >= 0; i--)
    {
        currentSum += currentPath[i];
        if (currentSum == targetSum)
        {
            int pathLength = currentPath.size() - i;
            longestLength = max(longestLength, pathLength);
        }
    }

    findLongestPath(currentNode->leftChild, targetSum, currentPath, longestLength);
    findLongestPath(currentNode->rightChild, targetSum, currentPath, longestLength);

    currentPath.pop_back();
}

int longestDownwardPathSumK(TreeNode *rootNode, int targetSum)
{
    vector<int> currentPath;
    int longestLength = 0;
    findLongestPath(rootNode, targetSum, currentPath, longestLength);
    return longestLength;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    vector<int> levelOrder(numberOfNodes);
    cout << "Enter node values in level order (-1 for null): ";
    for (int i = 0; i < numberOfNodes; i++)
    {
        cin >> levelOrder[i];
    }

    int targetSum;
    cout << "Enter target sum K: ";
    cin >> targetSum;

    TreeNode *rootNode = buildTreeFromLevelOrder(levelOrder);

    int result = longestDownwardPathSumK(rootNode, targetSum);
    cout << "Length of longest downward path with sum " << targetSum << " is: " << result;

    return 0;
}
