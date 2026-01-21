/**
 @Filename-DistantCousins.cpp
 @Description-Finds all cousin nodes of a given node X in a binary tree.
 @Author-Aditya Virmani
*/

#include <bits/stdc++.h>
using namespace std;

struct TreeNode
{
    int value;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int val)
    {
        value = val;
        left = nullptr;
        right = nullptr;
    }
};

TreeNode *buildBinaryTree(const vector<string> &inputNodes)
{
    if (inputNodes.empty() || inputNodes[0] == "null")
        return nullptr;

    TreeNode *root = new TreeNode(stoi(inputNodes[0]));
    queue<TreeNode *> nodeQueue;
    nodeQueue.push(root);

    int index = 1;
    while (!nodeQueue.empty() && index < inputNodes.size())
    {
        TreeNode *currentNode = nodeQueue.front();
        nodeQueue.pop();

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            currentNode->left = new TreeNode(stoi(inputNodes[index]));
            nodeQueue.push(currentNode->left);
        }
        index++;

        if (index < inputNodes.size() && inputNodes[index] != "null")
        {
            currentNode->right = new TreeNode(stoi(inputNodes[index]));
            nodeQueue.push(currentNode->right);
        }
        index++;
    }
    return root;
}

vector<int> findCousins(TreeNode *root, int target)
{
    vector<int> cousins;
    if (!root || root->value == target)
        return cousins;

    queue<pair<TreeNode *, TreeNode *>> q;
    q.push({root, nullptr});

    while (!q.empty())
    {
        int levelSize = q.size();
        TreeNode *targetParent = nullptr;
        vector<pair<TreeNode *, TreeNode *>> currentLevel;

        // store current level
        for (int i = 0; i < levelSize; i++)
        {
            auto curr = q.front();
            q.pop();
            currentLevel.push_back(curr);

            if (curr.first->value == target)
                targetParent = curr.second;
        }

        if (targetParent != nullptr)
        {
            for (auto &node : currentLevel)
            {
                if (node.second != targetParent && node.first->value != target)
                    cousins.push_back(node.first->value);
            }
            return cousins;
        }

        for (auto &node : currentLevel)
        {
            if (node.first->left)
                q.push({node.first->left, node.first});
            if (node.first->right)
                q.push({node.first->right, node.first});
        }
    }
    return cousins;
}

int main()
{
    cout << "Enter tree in level order (use 'null' for empty nodes):\n";
    cout << "Example: 1 2 3 null 4 null 5\n";

    string inputLine;
    getline(cin, inputLine);

    stringstream ss(inputLine);
    vector<string> inputNodes;
    string token;
    while (ss >> token)
        inputNodes.push_back(token);

    TreeNode *root = buildBinaryTree(inputNodes);

    int X;
    cout << "Enter value of node X: ";
    cin >> X;

    vector<int> cousins = findCousins(root, X);

    cout << "\nCousins of node " << X << ": ";
    if (cousins.empty())
        cout << "[]\n";
    else
    {
        cout << "[";
        for (int i = 0; i < cousins.size(); i++)
        {
            cout << cousins[i];
            if (i + 1 < cousins.size())
                cout << ", ";
        }
        cout << "]\n";
    }

    return 0;
}
