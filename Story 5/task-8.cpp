/**
 * @filename - Task-8.cpp
 * @description -  Lowest Common Ancestor (LCA) of a Set
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

TreeNode *findLCAofTwoNodes(TreeNode *rootNode, int firstValue, int secondValue)
{
    if (!rootNode)
        return NULL;

    if (rootNode->value == firstValue || rootNode->value == secondValue)
        return rootNode;

    TreeNode *leftResult = findLCAofTwoNodes(rootNode->leftChild, firstValue, secondValue);
    TreeNode *rightResult = findLCAofTwoNodes(rootNode->rightChild, firstValue, secondValue);

    if (leftResult && rightResult)
        return rootNode;

    if (leftResult)
        return leftResult;

    return rightResult;
}

int findLCAofMultipleNodes(TreeNode *rootNode, const vector<int> &nodesSet)
{
    if (nodesSet.size() == 1)
        return nodesSet[0];

    TreeNode *currentLCA = findLCAofTwoNodes(rootNode, nodesSet[0], nodesSet[1]);

    for (int i = 2; i < nodesSet.size(); i++)
    {
        currentLCA = findLCAofTwoNodes(rootNode, currentLCA->value, nodesSet[i]);
    }

    return currentLCA->value;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes in the tree: ";
    cin >> numberOfNodes;

    vector<int> levelOrder(numberOfNodes);
    cout << "Enter tree nodes in level order (-1 for null): ";
    for (int i = 0; i < numberOfNodes; i++)
    {
        cin >> levelOrder[i];
    }

    TreeNode *rootNode = buildTreeFromLevelOrder(levelOrder);

    int setSize;
    cout << "Enter number of nodes in the set: ";
    cin >> setSize;

    vector<int> nodesSet(setSize);
    cout << "Enter the node values: ";
    for (int i = 0; i < setSize; i++)
    {
        cin >> nodesSet[i];
    }

    int result = findLCAofMultipleNodes(rootNode, nodesSet);
    cout << "Lowest Common Ancestor of the given nodes is: " << result;

    return 0;
}
