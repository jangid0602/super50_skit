/**
 * @filename: Task4.cpp
 * @description:  Minimum cameras needed to cover a binary tree
 * @author:  Ayushi Shukla
 */

#include <iostream>
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

TreeNode *createTree(int totalNodes)
{
    if (totalNodes == 0)
        return nullptr;

    int rootValue;
    cin >> rootValue;

    if (rootValue == -1)
        return nullptr;

    TreeNode *rootNode = new TreeNode(rootValue);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(rootNode);

    int index = 1;
    while (!nodeQueue.empty() && index < totalNodes)
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        int leftValue, rightValue;

        // Left child
        cin >> leftValue;
        index++;
        if (leftValue != -1)
        {
            currentNode->left = new TreeNode(leftValue);
            nodeQueue.push(currentNode->left);
        }

        if (index >= totalNodes)
            break;

        // Right child
        cin >> rightValue;
        index++;
        if (rightValue != -1)
        {
            currentNode->right = new TreeNode(rightValue);
            nodeQueue.push(currentNode->right);
        }
    }

    return rootNode;
}

/*
States:
0 -> Needs camera
1 -> Has camera
2 -> Covered
*/
int placeCameras(TreeNode *currentNode, int &cameraCount)
{
    if (!currentNode)
        return 2;

    int leftState = placeCameras(currentNode->left, cameraCount);
    int rightState = placeCameras(currentNode->right, cameraCount);

    if (leftState == 0 || rightState == 0)
    {
        cameraCount++;
        return 1;
    }

    if (leftState == 1 || rightState == 1)
        return 2;

    return 0;
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    cout << "Enter tree values (level order, -1 for NULL):\n";
    TreeNode *rootNode = createTree(numberOfNodes);

    int cameraCount = 0;

    if (placeCameras(rootNode, cameraCount) == 0)
        cameraCount++;

    cout << "Minimum cameras required: " << cameraCount << endl;
    return 0;
}
