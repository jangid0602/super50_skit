/**
 @Filename-MinimumCameraCoverage.cpp
 @Description-Finds the minimum number of cameras required to monitor all nodes of a binary tree using a greedy approach.
 @Author-Aditya Virmani
 */

#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    string data;
    TreeNode *left;
    TreeNode *right;

    TreeNode(string value)
    {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

/*
 States:
 0 -> camera needed
 1 -> covered (no camera)
 2 -> has camera
*/
int placeCameras(TreeNode *currentNode, int &cameraCount)
{
    if (currentNode == nullptr)
        return 1;

    int leftState = placeCameras(currentNode->left, cameraCount);
    int rightState = placeCameras(currentNode->right, cameraCount);

    if (leftState == 1 && rightState == 1)
        return 0;

    if (leftState == 0 || rightState == 0)
    {
        cameraCount++;
        return 2;
    }

    return 1;
}

TreeNode *buildBinaryTree(const vector<string> &inputNodes)
{
    if (inputNodes.empty() || inputNodes[0] == "null")
        return nullptr;

    TreeNode *root = new TreeNode(inputNodes[0]);
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(root);

    int index = 1;
    while (!nodeQueue.empty() && index < inputNodes.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            currentNode->left = new TreeNode(inputNodes[index]);
            nodeQueue.push(currentNode->left);
        }
        index++;

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            currentNode->right = new TreeNode(inputNodes[index]);
            nodeQueue.push(currentNode->right);
        }
        index++;
    }
    return root;
}

int main()
{
    cout << "Enter tree in level order (use 'null' for empty nodes):\n";
    cout << "Example: A B null C D\n";
    cout << "Anything other than null we be treated as node\n";

    string inputLine;
    getline(cin, inputLine);

    if (inputLine.empty())
    {
        cout << "Error: No input provided.\n";
        return 0;
    }

    stringstream stream(inputLine);
    vector<string> inputNodes;
    string token;

    while (stream >> token)
    {
        inputNodes.push_back(token);
    }

    if (inputNodes[0] == "null")
    {
        cout << "Error: Root node cannot be null.\n";
        return 0;
    }

    TreeNode *root = buildBinaryTree(inputNodes);

    int cameraCount = 0;
    int rootState = placeCameras(root, cameraCount);

    if (rootState == 0)
        cameraCount++;

    cout << "\nMinimum cameras required: " << cameraCount << endl;

    return 0;
}
