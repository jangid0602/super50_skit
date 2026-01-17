/**
 * @filename - Task-7.cpp
 * @description - Boundary Traversal
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct TreeNode
{
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int data)
    {
        value = data;
        left = NULL;
        right = NULL;
    }
};

TreeNode *buildTreeFromLevelOrder(const vector<int> &levelOrder)
{
    if (levelOrder.empty() || levelOrder[0] == -1)
        return NULL;

    TreeNode *root = new TreeNode(levelOrder[0]);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(root);

    int index = 1;
    while (!nodeQueue.empty() && index < levelOrder.size())
    {
        TreeNode *current = nodeQueue.front();
        nodeQueue.pop();

        if (levelOrder[index] != -1)
        {
            current->left = new TreeNode(levelOrder[index]);
            nodeQueue.push(current->left);
        }
        index++;

        if (index < levelOrder.size() && levelOrder[index] != -1)
        {
            current->right = new TreeNode(levelOrder[index]);
            nodeQueue.push(current->right);
        }
        index++;
    }
    return root;
}

bool isLeaf(TreeNode *node)
{
    return node && !node->left && !node->right;
}

void printLeftBoundary(TreeNode *root)
{
    TreeNode *current = root->left;
    while (current)
    {
        if (!isLeaf(current))
            cout << current->value << " ";
        if (current->left)
            current = current->left;
        else
            current = current->right;
    }
}

void printLeaves(TreeNode *root)
{
    if (!root)
        return;

    if (isLeaf(root))
    {
        cout << root->value << " ";
        return;
    }

    printLeaves(root->left);
    printLeaves(root->right);
}

void printRightBoundary(TreeNode *root)
{
    vector<int> rightBoundary;
    TreeNode *current = root->right;

    while (current)
    {
        if (!isLeaf(current))
            rightBoundary.push_back(current->value);
        if (current->right)
            current = current->right;
        else
            current = current->left;
    }

    for (int i = rightBoundary.size() - 1; i >= 0; i--)
        cout << rightBoundary[i] << " ";
}

void printBoundary(TreeNode *root)
{
    if (!root)
        return;

    cout << root->value << " ";

    printLeftBoundary(root);
    printLeaves(root->left);
    printLeaves(root->right);
    printRightBoundary(root);
}

int main()
{
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    vector<int> levelOrder(numberOfNodes);
    cout << "Enter tree in level order (-1 for null): ";
    for (int i = 0; i < numberOfNodes; i++)
        cin >> levelOrder[i];

    TreeNode *root = buildTreeFromLevelOrder(levelOrder);

    cout << "Boundary Traversal (Anti-clockwise): ";
    printBoundary(root);

    return 0;
}
