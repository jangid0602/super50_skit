/**
 * @filename:    Task7.cpp
 * @description: Boundary Traversal of Binary Tree
 * @author:      Ayushi Shukla
 */

#include <iostream>
#include <vector>
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

void insertNode(TreeNode *rootNode, int nodeValue, char direction)
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

vector<vector<int>> levelOrderTraversal(TreeNode *rootNode)
{
    vector<vector<int>> levelWise;
    if (!rootNode)
        return levelWise;

    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    while (!nodeQueue.empty())
    {
        int levelSize = nodeQueue.size();
        vector<int> currentLevel;

        for (int i = 0; i < levelSize; i++)
        {
            TreeNode *currentNode = nodeQueue.front();
            nodeQueue.pop();

            currentLevel.push_back(currentNode->value);

            if (currentNode->left)
                nodeQueue.push(currentNode->left);
            if (currentNode->right)
                nodeQueue.push(currentNode->right);
        }
        levelWise.push_back(currentLevel);
    }
    return levelWise;
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
        char direction;

        cout << "Enter node value: ";
        cin >> nodeValue;

        cout << "Enter direction (L/R): ";
        cin >> direction;

        insertNode(rootNode, nodeValue, direction);
    }

    cout << "Tree created successfully\n";

    vector<vector<int>> levelWise = levelOrderTraversal(rootNode);
    vector<int> boundaryTraversal;

    int totalLevels = levelWise.size();

    // Root
    boundaryTraversal.push_back(rootNode->value);

    // Left boundary (excluding leaves)
    for (int level = 1; level < totalLevels - 1; level++)
    {
        if (levelWise[level].size() > 1)
            boundaryTraversal.push_back(levelWise[level][0]);
    }

    // Leaf nodes (left to right)
    for (int level = 1; level < totalLevels; level++)
    {
        int levelSize = levelWise[level].size();

        if (levelSize == 1)
        {
            boundaryTraversal.push_back(levelWise[level][0]);
        }
        else if (level == totalLevels - 1)
        {
            for (int value : levelWise[level])
                boundaryTraversal.push_back(value);
        }
    }

    // Right boundary (excluding leaves, bottom to top)
    for (int level = totalLevels - 2; level >= 1; level--)
    {
        if (levelWise[level].size() > 1)
            boundaryTraversal.push_back(
                levelWise[level][levelWise[level].size() - 1]);
    }

    cout << "Boundary Traversal is:\n";
    for (int value : boundaryTraversal)
    {
        cout << value << " ";
    }

    return 0;
}
