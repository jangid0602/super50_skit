/**
 * @filename - Task-7.cpp
 * @description - The Binary Tree Audit
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

    TreeNode(int x)
    {
        value = x;
        leftChild = rightChild = NULL;
    }
};

TreeNode *buildTree(vector<string> &nodeValues)
{
    if (nodeValues.size() == 0 || nodeValues[0] == "null")
        return NULL;

    TreeNode *rootNode = new TreeNode(stoi(nodeValues[0]));
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    int index = 1;

    while (index < nodeValues.size() && !nodeQueue.empty())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        // Left child
        if (nodeValues[index] != "null")
        {
            currentNode->leftChild = new TreeNode(stoi(nodeValues[index]));
            nodeQueue.push(currentNode->leftChild);
        }
        index++;

        if (index >= nodeValues.size())
            break;

        // Right child
        if (nodeValues[index] != "null")
        {
            currentNode->rightChild = new TreeNode(stoi(nodeValues[index]));
            nodeQueue.push(currentNode->rightChild);
        }
        index++;
    }

    return rootNode;
}

pair<int, int> dfs(TreeNode *rootNode)
{
    if (rootNode == NULL)
        return {0, 0};

    auto leftResult = dfs(rootNode->leftChild);
    auto rightResult = dfs(rootNode->rightChild);

    int includeCurrent = rootNode->value + leftResult.second + rightResult.second;
    int excludeCurrent = max(leftResult.first, leftResult.second) + max(rightResult.first, rightResult.second);

    return {includeCurrent, excludeCurrent};
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes in a tree: ";
    cin >> numberOfNodes;

    vector<string> nodeValues(numberOfNodes);
    cout << "Enter tree elements ('null' for empty nodes):\n";
    for (int i = 0; i < numberOfNodes; i++)
    {
        cin >> nodeValues[i];
    }

    TreeNode *rootNode = buildTree(nodeValues);

    pair<int, int> finalResult = dfs(rootNode);
    int maximumEfficiency = max(finalResult.first, finalResult.second);

    cout << "\nMaximum Efficiency that can be achieved: "
         << maximumEfficiency << endl;

    return 0;
}
