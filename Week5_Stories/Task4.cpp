/**
 * @filename - Task4.cpp
 * @description - Minimum cameras needed to cover a binary tree
 * @author - Diya Garg
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
        left = right = nullptr;
    }
};

TreeNode *createTree(int nodeCount)
{
    if (nodeCount == 0)
        return nullptr;

    int rootValue;
    cin >> rootValue;
    if (rootValue == -1)
        return nullptr;

    TreeNode *root = new TreeNode(rootValue);
    queue<TreeNode *> q;
    q.push(root);

    int index = 1;
    while (!q.empty() && index < nodeCount)
    {
        TreeNode *current = q.front();
        q.pop();

        int leftValue, rightValue;

        cin >> leftValue;
        index++;
        if (leftValue != -1)
        {
            current->left = new TreeNode(leftValue);
            q.push(current->left);
        }

        if (index >= nodeCount)
            break;

        cin >> rightValue;
        index++;
        if (rightValue != -1)
        {
            current->right = new TreeNode(rightValue);
            q.push(current->right);
        }
    }
    return root;
}

int cameraCount = 0;

int placeCameras(TreeNode *root)
{
    if (!root)
        return 2;

    int leftState = placeCameras(root->left);
    int rightState = placeCameras(root->right);

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
    TreeNode *root = createTree(numberOfNodes);

    if (placeCameras(root) == 0)
        cameraCount++;

    cout << "Minimum cameras required: " << cameraCount << endl;

    return 0;
}